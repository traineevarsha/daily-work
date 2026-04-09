import { useState } from "react";
function QuestionCard({ questions, selectedIds, index, updateSelectedId, updateAnswer, updateConfirmAnswer, hide }) {
  const [questionId, setQuestionId]=useState("");
  const [answer, setAnswer]=useState("");
  const [confirmAnswer, setConfirmAnswer]=useState("");
  const isEmptyAnswer=answer.trim()==="";
  const isShortAnswer=answer.trim()!==""&&answer.trim().length<3;
  return (
    <div className="question-row">
  <label className="question-label">Question:</label>
  <div className="field-block">
    <select
      className="question-select" value={questionId} onChange={(event)=>{setQuestionId(event.target.value);updateSelectedId(index, event.target.value);}}>
      <option value="">Select question</option>
      {questions.filter((question)=>selectedIds[index]===String(question.questionId)||!selectedIds.includes(String(question.questionId)))
        .map((question)=>(
          <option key={question.questionId} value={question.questionId}>{question.questionText}</option>))}
    </select>
  </div>
  <div className="field-block">
    <input
      className={`answer-input${isEmptyAnswer||isShortAnswer?"input-error":""}`}
      type={hide?"password":"text"} placeholder="Answer" value={answer}
      onChange={(event)=>{setAnswer(event.target.value);updateAnswer(index,event.target.value);}}/>
    {isEmptyAnswer&&<p className="error-text">Please fill this answer</p>}{isShortAnswer&&<p className="error-text">Minimum 3 characters required</p>}
  </div>
  <div className="field-block">
    <input
      className={`confirm-input ${answer !== "" && confirmAnswer !== "" && answer !== confirmAnswer ? "input-error" : ""}`}
      type={hide ? "password" : "text"} placeholder="Confirm Answer" value={confirmAnswer}
      onChange={(event)=>{setConfirmAnswer(event.target.value);updateConfirmAnswer(index, event.target.value);
      }}/>
    {answer !== "" && confirmAnswer !== "" && answer !== confirmAnswer && <p className="error-text">Answers do not match</p>}
  </div>
</div>
  );
}
export default QuestionCard;