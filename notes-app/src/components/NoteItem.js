function NoteItem({ note, deleteNote }) {
  return (
    <li className="note-item">
      <div>
        <span className="note-text">{note.title}</span>
        <span className="note-status">{note.status}</span>
      </div>
      <button
        className="delete-button" onClick={() => deleteNote(note.id)}>
        Delete
      </button>
    </li>
  );
}

export default NoteItem;