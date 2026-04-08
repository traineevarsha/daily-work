const express = require("express");
const cors = require("cors");
const fs = require("fs");

const app = express();

app.use(cors());
app.use(express.json());

app.get("/questions", (req, res) => {
  const data = fs.readFileSync("questions.json", "utf-8");
  res.send(JSON.parse(data));
});

app.post("/answers", (req, res) => {
  fs.writeFileSync("answers.json", JSON.stringify(req.body, null, 2));
  res.send("Answers saved");
});

module.exports = app;

if (require.main === module) {
  app.listen(5000, () => {
    console.log("Server running on port 5000");
  });
}