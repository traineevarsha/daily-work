const {describe,it} = require("mocha");
const app = require ('../server');
const request = require("supertest");
const {expect} = require('chai');

describe('GET /notes', ()=> {
    it('hould return 200 and an array of notes when GET is called',async () =>{
        console.log(request);
        const response = await request(app).get('/notes');
        expect(response.status).to.equal(200);
        expect(response.body).to.be.an('array');
    });
    it('should return 404 when GET is called with a non existing id', async ()=>{
        console.log(request);
        const response = await request(app).get('/notes/123');
        expect(response.status).to.equal(404);
    });
});

describe('POST /notes', ()=> {
    it('should create a new note and return 201 status', async () => {
        const response = await request(app)
            .post('/notes')
            .send({ title: 'taskA', content: 'this is a note' });
        expect(response.status).to.equal(201);
    });
    it('should return 400 if title is empty in POST ', async () => {
        const response = await request(app)
            .post('/notes').send({ title: '', content: 'some content' });
        expect(response.status).to.equal(400);
    });
    it('should return 400 if POST is called with empty content', async () => {
        const response = await request(app)
            .post('/notes')
            .send({ title: 'task3', content: '' });
        expect(response.status).to.equal(400);
    });
    it('should create a note with status field set to "created', async () => {
        const response = await request(app)
            .post('/notes')
            .send({ title: 'task status', content: 'checking status' });
        expect(response.status).to.equal(201);
        expect(response.body.status).to.equal('created');
    });
});

describe('DELETE /notes', ()=> {
    it('should delete note successfully and return 200', async () => {
        const saveResponse = await request(app).post('/notes').send({ title: 'test', content: 'test' });
        const id = saveResponse.body.id;
        const response = await request(app).delete('/notes/' + id);
        expect(response.status).to.equal(200);
    });
    it('should return 404 when deleting nonexisting note', async () => {
        const response = await request(app).delete('/notes/123456');
        expect(response.status).to.equal(404);
    });
});

describe('PUT /notes', ()=> {
    it('should update note successfully and return 200', async () => {
        const saveResponse = await request(app).post('/notes').send({ title: 'task1', content: 'this is a note' });
        const id = saveResponse.body.id;
        const response = await request(app).put('/notes/' + id).send({ title: 'new title', content: 'new content' });
        expect(response.status).to.equal(200);
    });
    it('should return Updated message for put request', async () => {
        const saveResponse = await request(app).post('/notes').send({ title: 'task1', content: 'this is a note' });
        const id = saveResponse.body.id;
        const response = await request(app).put('/notes/' + id).send({ title: 'new', content: 'new' });
        expect(response.status).to.equal(200);
        expect(response.body.message).to.equal('Updated');
    });
    it('should update only title successfully with status 200', async () => {
        const saveResponse = await request(app).post('/notes').send({ title: 'old title', content: 'old content' });
        const id = saveResponse.body.id;
        await request(app).put('/notes/' + id).send({ title: 'new title' });
        const getResponse = await request(app).get('/notes/' + id);
        expect(getResponse.status).to.equal(200);
        expect(getResponse.body.title).to.equal('new title');
    });
    it('should update only content successfully with status 200', async () => {
        const saveResponse = await request(app).post('/notes').send({ title: "TaskB", content: "Some content" });
        const id = saveResponse.body.id;
        await request(app).put('/notes/' + id).send({ content: "new content" });
        const getResponse = await request(app).get('/notes/' + id);
        expect(getResponse.status).to.equal(200);
        expect(getResponse.body.content).to.equal('new content');
    });
    it('should return 404 when updating non-existing note', async () => {
        const response = await request(app)
            .put('/notes/123')
            .send({ title: 'New title' });
        expect(response.status).to.equal(404);
        expect(response.body.error).to.equal('Not found');
    });
 
});