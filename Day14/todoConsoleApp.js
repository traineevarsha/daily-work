const fs = require('fs').promises;
const FILE = 'notes.json';

async function init() {
  try {
    await fs.access(FILE);
    const data = await fs.readFile(FILE, 'utf8');
    if (!data.trim()) {
      await fs.writeFile(FILE, JSON.stringify([]));
    }
  } catch {
    await fs.writeFile(FILE, JSON.stringify([]));
  }
}

async function getNotes() {
  const data = await fs.readFile(FILE, 'utf8');
  return JSON.parse(data);
}

async function saveNotes(notes) {
  await fs.writeFile(FILE, JSON.stringify(notes, null, 2));
}

async function addNote(title, content) {
  const notes = await getNotes();

  const newNote = {
    id: Date.now(),
    title,
    content
  };

  notes.push(newNote);
  await saveNotes(notes);

  console.log('Note added:', newNote);
}

async function listNotes() {
  const notes = await getNotes();
  console.log('Notes:', notes);
}

async function getNote(id) {
  const notes = await getNotes();
  const note = notes.find(note => note.id == id);

  if (!note) {
    return console.log('note not found');
  }

  console.log('found', note);
}

async function updateNote(id, newContent) {
  const notes = await getNotes();

  const updated = notes.map(note =>
    note.id == id ? { ...note, content: newContent } : note
  );

  await saveNotes(updated);
  console.log('note updated');
}

async function deleteNote(id) {
  const notes = await getNotes();
  const filtered = notes.filter(note => note.id != id);

  await saveNotes(filtered);
  console.log('note deleted');
}

async function run() {
  
  await init();
  const [,, command, ...args] = process.argv;

  switch (command) {
    case 'add':
      await addNote(args[0], args[1]);
      break;
    case 'list':
      await listNotes();
      break;
    case 'get':
      await getNote(args[0]);
      break;
    case 'update':
      await updateNote(args[0], args[1]);
      break;
    case 'delete':
      await deleteNote(args[0]);
      break;
    default:
      console.log(`Usage:
node todoConsole.js add "Title" "Content"
node todoConsole.js list
node todoConsole.js get <id>
node todoConsole.js update <id> "New Content"
node todoConsole.js delete <id>`);
  }
}

run();
