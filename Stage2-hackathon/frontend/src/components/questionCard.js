import { useState } from "react";
function QuestionCard({ questions, selectedIds, index, updateSelectedId, updateAnswer, hide }) {
  const [questionId, setQuestionId] = useState(String(index + 1));
  const [answer, setAnswer] = useState("testanswer");
  const [confirmAnswer, setConfirmAnswer] = useState("testanswer");
  return (
    <div className="question-row">
      <label className="question-label">Question :</label>
      <select
        className="question-select"
        value={questionId}
        onChange={(event) => {
          setQuestionId(event.target.value);
          updateSelectedId(index, event.target.value);
        }}>
        <option value="">Select question</option>
        {questions.filter((question) =>selectedIds[index] === String(question.questionId) ||!selectedIds.includes(String(question.questionId)))
          .map((question) => (
            <option key={question.questionId} value={question.questionId}>{question.questionText}
            </option>
          ))}
      </select>
      <input
        className="answer-input"
        type={hide ? "password" : "text"}
        placeholder="Answer"
        value={answer}
        onChange={(event) => { setAnswer(event.target.value); updateAnswer(index, event.target.value);
        }}
      />
      <input
        className="confirm-input"
        type={hide ? "password" : "text"}
        placeholder="Confirm Answer"
        value={confirmAnswer}
        onChange={(event) => setConfirmAnswer(event.target.value)}
      />
{answer !== "" && confirmAnswer !== "" && answer !== confirmAnswer && (<p style={{ color: "red", fontSize: "14px" }}>Please ensure ur answer and confirm answer are identical.
  </p>
)}
    </div>
  );
}
export default QuestionCard;