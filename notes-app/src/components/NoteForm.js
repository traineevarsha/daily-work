import { useState } from "react";
function NoteForm({ addNote }) {
  const today = new Date().toISOString().split("T")[0];
  const [note, setNote] = useState({
    title: "",
    content: "",
    startDate: "",
    endDate: "",
    priority: 0
  });
  const getPriorityText = (value) => {
    if (value <= 10) return "Low";
    if (value <= 20) return "Medium";
    return "High";
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    if (!note.title.trim()) {
      alert("Title is required");
      return;
    }
    if (note.title.length>200||note.content.length>200) {
      alert("Maximum 200 characters only are allowed");
      return;
    }
    if (note.startDate<today) {
      alert("Start date canot be in the past");
      return;
    }
    if (note.endDate<note.startDate) {
      alert("End date must be after start date");
      return;
    }
    console.log({...note,priority:getPriorityText(note.priority)});
    addNote({...note, priority:getPriorityText(note.priority)
    });
    setNote({title: "",content: "",startDate: "",endDate: "",priority: 0});
  };
  return (
    <form className="form" onSubmit={handleSubmit}>
      <div className="form-row">
        <label>Task Title ({note.title.length}/200)</label>
        <input
          type="text"
          placeholder="Enter task title"
          maxLength={200}
          value={note.title}
          onChange={(event) =>
            setNote({ ...note, title: event.target.value })
          }className={note.title.length > 180 ? "warning" : ""}/>
      </div>
      <div className="form-row">
  <label>
    Task Description ({note.content.length}/200)
  </label>
  <textarea
    placeholder="Enter description"
    maxLength={200}
    value={note.content}
    onChange={(e) =>
      setNote({ ...note, content: e.target.value })
    }
    className={note.content.length > 180 ? "warning" : ""}/>
</div>
      <div className="form-row">
        <label>Start Date</label>
        <input
          type="date"
          min={today}
          value={note.startDate}
          onChange={(event) =>
            setNote({ ...note, startDate: event.target.value })}/>
      </div>
      <div className="form-row">
        <label>End Date</label>
        <input
          type="date"
          min={note.startDate||today}
          value={note.endDate}
          onChange={(event)=>setNote({ ...note, endDate: event.target.value })}/>
      </div>
      <div className="form-row">
        <label>Priority:{note.priority}({getPriorityText(note.priority)})
        </label>
        <input
          type="range"
          min="0"
          max="30"
          value={note.priority}
          onChange={(event)=>setNote({...note,priority:Number(event.target.value) })
          }
        />
      </div>
      <button type="submit">Add Task</button>
    </form>
  );
}
export default NoteForm;