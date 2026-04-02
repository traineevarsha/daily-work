
import { useState } from "react";

function NoteForm({ addNote }) {
  const [note, setNote] = useState({
    title: "my note",
    status: "created"
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    addNote(note);
    setNote({
      title: "",
      status: ""
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        placeholder="Enter note"
        value={note.title}
        onChange={(event) => setNote({ ...note, title: event.target.value })}
      />
      <input
        value={note.status}
        onChange={(event) => setNote({ ...note, status: event.target.value })}
      />
      <button>Add</button>
    </form>
  );
}

export default NoteForm;