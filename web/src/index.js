import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom/client';
import axios from 'axios';
import Login from './components/Login';

const App = () => {
  const [message, setMessage] = useState('');

  useEffect(() => {
    // Cambia la URL al endpoint de tu API
    axios.get('http://localhost:8081/api/endpoint')
      .then((response) => setMessage(response.data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <Login />
      <h1>{message || 'Loading...'}</h1>
    </div>
  );
};

// Usar ReactDOM.createRoot en lugar de ReactDOM.render
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
