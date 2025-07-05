import React, { useEffect, useState } from 'react';
import './index.css';

const API_URL = import.meta.env.VITE_API_BASE 

function App() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  // Load tasks
  useEffect(() => {
    fetch(`${API_URL}/tasks`)
      .then(res => res.json())
      .then(data => setTasks(data));
  }, []);

  const addTask = async () => {
    const res = await fetch(`${API_URL}/tasks`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ title, description }),
    });
    const newTask = await res.json();
    setTasks(prev => [newTask, ...prev].slice(0, 5));
    setTitle('');
    setDescription('');
  };

  const markDone = async (id) => {
    await fetch(`${API_URL}/tasks/${id}`, { method: 'PUT' });
    setTasks(prev => prev.filter(task => task.id !== id));
  };

  return (
    <div className="container">
      <div className="app-box">
        <h1 className="app-title">📝 My To-Do App</h1>

        <div className="form-section">
          <input
            type="text"
            placeholder="Task Title"
            value={title}
            onChange={e => setTitle(e.target.value)}
          />
          <textarea
            placeholder="Task Description"
            value={description}
            onChange={e => setDescription(e.target.value)}
          />
          <button onClick={addTask}>➕ Add Task</button>
        </div>

        <div className="task-list">
          {tasks.map(task => (
            <div key={task.id} className="task-card">
              <div>
                <h3>{task.title}</h3>
                <p>{task.description}</p>
              </div>
              <button className="done-button" onClick={() => markDone(task.id)}>
                ✅ Done
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
