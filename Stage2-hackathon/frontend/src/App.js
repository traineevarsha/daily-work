import { useEffect, useState } from "react";
import QuestionCard from "./components/questionCard";
import "./App.css";
function App() {
  const [questions, setQuestions] = useState([]);
  const [selectedIds, setSelectedIds] = useState(["","","",""]);
  const [answers, setAnswers] = useState(["","","",""]);
  const [confirmAnswers, setConfirmAnswers] = useState(["","","",""]);
  const [hide, setHide] = useState(false);
  const [error, setError] = useState("");
  useEffect(()=>{
    fetch("http://localhost:5000/questions").then((response)=>response.json()).then((data)=>setQuestions(data)).catch((error) => console.log(error));},[]);
  const updateSelectedId=(index, value)=>{
    const updated=[...selectedIds];
    updated[index]=value;
    setSelectedIds(updated);
  };
  const updateAnswer=(index,value)=>{const updated = [...answers];
    updated[index] = value;
    setAnswers(updated);
  };
  const updateConfirmAnswer=(index, value)=>{const updated=[...confirmAnswers];
    updated[index] = value;
    setConfirmAnswers(updated);
  };
  const unique = new Set(selectedIds.filter(id=>id!==""));
  const hasShortAnswer=answers.some(answer=>answer.trim().length<3);
  const isFormValid=!selectedIds.includes("")&&!answers.some(answer=>answer.trim()==="")&&!confirmAnswers.some(confirmAnswer=>confirmAnswer.trim()==="")&&!hasShortAnswer&&unique.size===selectedIds.length&&answers.every((answer,index)=>answer===confirmAnswers[index]);
  const handleSubmit=()=>{
    if (answers.some(answer=>answer.trim()==="")||confirmAnswers.some(confirmAnswer=>confirmAnswer.trim()==="")) {setError("Please fill all fields");return;}
    if (hasShortAnswer) {setError("Answer must be at least 3 characters");return;}
    if (!isFormValid) {setError("Please correct all fields before submitting");return;}
    setError("");
    const finalData = selectedIds.map((value, index) => ({ questionId: value, answer: answers[index], confirmAnswer: confirmAnswers[index] }));
    fetch("http://localhost:5000/answers", {method: "POST",headers: { "Content-Type": "application/json" },body: JSON.stringify(finalData)
    }).then((response) => response.text()).then((data) => console.log(data)).catch((error) => console.log(error));
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
          updateConfirmAnswer={updateConfirmAnswer}
          hide={hide}/>))}
      <div className="bottom-section">
  <label className="checkbox-row">
    <input type="checkbox" checked={hide} onChange={() => setHide(!hide)} /> Hide Answers</label>
  <button className="submit-button" onClick={handleSubmit} disabled={!isFormValid}>Submit</button>
</div></div>);
}
export default App;