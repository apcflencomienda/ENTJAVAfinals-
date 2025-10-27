
async function fetchFlights() {
  try {
    const res = await fetch('/api/flights');
    const flights = await res.json();
    const root = document.getElementById('root');
    root.innerHTML = '<h1>Airline Ticketing (served by Spring Boot)</h1>';
    const table = document.createElement('table');
    table.style.borderCollapse='collapse';
    table.innerHTML = '<tr><th>Number</th><th>Origin</th><th>Destination</th><th>Departure</th><th>Arrival</th><th>Price</th></tr>';
    flights.forEach(f => {
      const tr = document.createElement('tr');
      tr.innerHTML = `<td>${f.flightNumber}</td><td>${f.origin}</td><td>${f.destination}</td><td>${new Date(f.departureTime).toLocaleString()}</td><td>${f.arrivalTime? new Date(f.arrivalTime).toLocaleString(): '-'}</td><td>₱ ${f.price?.toFixed(2) || '-'}</td>`;
      table.appendChild(tr);
    });
    root.appendChild(table);
    root.appendChild(document.createElement('br'));
    root.appendChild(document.createTextNode('This is a minimal combined build. Use the frontend/ folder for full React development.'));
  } catch (e) {
    console.error(e);
    document.getElementById('root').innerText = 'Failed to load flights: ' + e;
  }
}
fetchFlights();
