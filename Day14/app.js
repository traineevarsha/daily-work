const fs = require('fs').promises;
function readFile() {
  fs.readFile('data.txt', 'utf8', (err, data) => {
    if (err) {
      console.error(err);
      return;
    }
    console.log(data);
  });
}
function writeFile() {
  fs.writeFile('data.txt', 'Hello World', (err) => {
    if (err) console.error(err);
    else console.log('File written');
  });
}
//writeFile();
//readFile();


function readFileWithPromise(){
    fs.readFile("data.txt", "utf8")
        .then(result => console.log(result))
        .catch(error => console.log(error));
}
function writeFileWithPromise(){
    fs.writeFile("data.txt", "This is more sample data")
    .then(() => console.log("Written"))
    .catch(err => console.error(err));
}
function appendFileWithPromise(){
    fs.appendFile('data.txt', "\n more data to display")
    .then(() => console.log("appended"));
}
function deleteFileWithPromise(){
    fs.unlink('data.txt')
    .then(() => console.log('Deleted'));
}
function checkFileExists(){
  fs.access('data.txt')
  .then(() => console.log("exists"))
  .catch(() => console.log("does not exist"));  
}
//checkFileExists();
// appendFileWithPromise();
// writeFileWithPromise();
// readFileWithPromise();

async function readFileWithAsyncAwaits(){
  try{
    const data = await fs.readFile('data.txt','utf8');
    console.log(data);
  }catch (err){
    console.error(err);
  }
}

async function writeFileWithAsyncAwait(params) {
  try{
   await fs.writeFile('data.txt','Async Await Trial');
   console.log('File written');
  } catch(err) {
    console.error(err);
  } 
}

async function appendFileWithAsyncAwait(params) {
    await fs.appendFile('data.txt', '\n Appending...');
}
async function deleteFileWithAsyncAwait(){
  await fs.unlink('data.txt');
}
//writeFileWithAsyncAwait();
readFileWithAsyncAwaits();