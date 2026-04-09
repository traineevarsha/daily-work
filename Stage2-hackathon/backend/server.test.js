const request = require("supertest");
const fs = require("fs");
const app = require("./server");
describe("Backend API Tests", () => {
  test("GET /questions should return questions list", async()=>{
    const response = await request(app).get("/questions");
    expect(response.statusCode).toBe(200);
    expect(Array.isArray(response.body)).toBe(true);
    expect(response.body.length).toBeGreaterThan(0);
    expect(response.body[0]).toHaveProperty("questionId");
    expect(response.body[0]).toHaveProperty("questionText");
  });
  test("POST /answers should save answers",async()=>{
    const sampleAnswers=[{questionId:"1",answer:"Priya",confirmAnswer:"Priya"},
      {questionId:"2",answer:"Milo",confirmAnswer:"Milo"}];
    const response = await request(app)
      .post("/answers").send(sampleAnswers);
    expect(response.statusCode).toBe(200);
    expect(response.text).toBe("Answers saved");
  });
  test("answers.json should contain saved answers",()=>{
    const data = fs.readFileSync("answers.json","utf-8");
    const answers = JSON.parse(data);
    expect(Array.isArray(answers)).toBe(true);
    expect(answers.length).toBeGreaterThan(0);
    expect(answers[0]).toHaveProperty("questionId");
    expect(answers[0]).toHaveProperty("answer");
    expect(answers[0]).toHaveProperty("confirmAnswer");
  });
  test("Each question should have correct structure", async()=>{
  const response = await request(app).get("/questions");
  const questions = response.body;
  questions.forEach((question) => {expect(typeof question.questionId).toBeDefined();
    expect(typeof question.questionText).toBe("string");
  });
});
test("POST answers should fail if answer and confirmanswer dont match",async()=>{
  const invalidData=[{questionId: "1",answer: "abc",confirmAnswer: "xyz"}];
  const response = await request(app).post("/answers").send(invalidData);
  expect(response.statusCode).toBe(400);
});
});