const express = require("express");
const cors = require("cors");
const fs = require("fs");
const app = express();
app.use(cors());
app.use(express.json());
app.get("/questions", (request, response) => {
  const data = fs.readFileSync("questions.json", "utf-8");
  response.send(JSON.parse(data));
});
app.post("/answers", (request, response) => {
  fs.writeFileSync("answers.json", JSON.stringify(request.body, null,2));
  response.send("Answers saved");
});
module.exports = app;
if (require.main===module) {
  app.listen(5000, () =>{
    console.log("Server isrunning on port 5000");
  });
}