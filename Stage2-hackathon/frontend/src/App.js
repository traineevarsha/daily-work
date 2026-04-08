import { useEffect, useState } from "react";
import QuestionCard from "./components/questionCard";
import "./App.css"; 
function App() {
  const [questions, setQuestions] = useState([]);
  const [selectedIds, setSelectedIds] = useState(["1", "2", "3", "4"]);
  const [answers, setAnswers] = useState(["Priya", "Maya", "Pasta", "NHG"]);
  const [hide, setHide] = useState(false);
  useEffect(() => {
    fetch("http://localhost:5000/questions")
      .then((response) => response.json())
      .then((data) => setQuestions(data))
      .catch((error) => console.log(error));
  }, []);
  const updateSelectedId = (index, value) => {
    const updated = [...selectedIds];
    updated[index] = value;
    setSelectedIds(updated);
  };
  const updateAnswer = (index, value) => {
    const updated = [...answers];
    updated[index] = value;
    setAnswers(updated);
  };
  const handleSubmit = () => {
    const finalData = selectedIds.map((value, index) => ({
      questionId: value,
      answer: answers[index]
    }));
    fetch("http://localhost:5000/answers", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(finalData)
    })
      .then((response) => response.text())
      .then((data) => console.log(data))
      .catch((error) => console.log(error));
  };
  return (
    <div className="container">
      <h2>Security Questions</h2>
      {selectedIds.map((value, index) => (
        <QuestionCard
          key={index}
          questions={questions}
          selectedIds={selectedIds}
          index={index}
          updateSelectedId={updateSelectedId}
          updateAnswer={updateAnswer}
          hide={hide}
        />
      ))}
      <div className="bottom-section">
        <label className="checkbox-row">
          <input type="checkbox" checked={hide} onChange={() => setHide(!hide)}/>{" "}Hide Answers
        </label>
        <button className="submit-button" onClick={handleSubmit}>
          Submit
        </button>
      </div>
    </div>
  );
}
export default App;