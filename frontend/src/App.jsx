
import React, {useEffect, useState} from 'react'; import axios from 'axios'; const API_BASE='/api';
export default function App(){ const [flights,setFlights]=useState([]); useEffect(()=>{ axios.get(`${API_BASE}/flights`).then(r=>setFlights(r.data)).catch(console.error); },[]);
return (<div style={{padding:20}}><h1>Airline Ticketing (React)</h1><ul>{flights.map(f=><li key={f.id}>{f.flightNumber} {f.origin}->{f.destination} - ₱ {f.price?.toFixed(2)}</li>)}</ul></div>); }
