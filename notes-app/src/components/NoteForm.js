import { useState } from "react";
function NoteForm({ addNote }) {
  const [note, setNote] = useState({
    title: "",
    status: "open"
  });
  const handleSubmit = (event) => {
    event.preventDefault();
    addNote(note);
    setNote({
      title: "",
      status: "open"
    });
  };
  return (
    <form className= "note-form" onSubmit={handleSubmit}>
      <input
        placeholder="Enter Note"
        value={note.title}
        onChange={(event) => setNote({ ...note, title: event.target.value })}
      />
      <label className = "checkbox-row">
        <input
          type="checkbox"
          checked={note.status === "closed"}
          onChange={(event) =>
            setNote({
              ...note,
              status: event.target.checked ? "closed" : "open"
           })
          }
        />
      Status 
      </label>
      <button>Add</button>
    </form>
  );
}
export default NoteForm;