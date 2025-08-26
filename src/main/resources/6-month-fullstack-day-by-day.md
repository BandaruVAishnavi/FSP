# 6-Month Full‑Stack Developer Plan — Day‑by‑Day (with Code)

**Assumptions & Stack**
- OS: macOS/Windows/Linux, Terminal + VS Code
- Runtime: Node.js LTS, npm
- Frontend: HTML, CSS (including Flexbox/Grid), JavaScript (ES6+), React + React Router, Tailwind CSS
- Backend: Node.js + Express
- Databases: PostgreSQL (SQL), MongoDB (NoSQL)
- Auth: JWT (stateless), cookies/sessions basics
- Testing: Jest (unit), Supertest (API)
- DevOps: Git/GitHub, Docker, basic CI, deployment to Vercel/Render
- Optional: GraphQL, Stripe

**How to Use**
- Each day has a focused goal, tiny deliverable, and code snippet(s).
- Build the mini-projects exactly as written; don’t skip deployment days.
- If a day runs long, split it into two. Momentum beats “perfect.”

---


## Month 1 — Web Foundations (Days 1–30)

### Day 1: Environment Setup + Git
- **Goal:** Install Node LTS, VS Code, Git. Create a playground repo.
```bash
node -v && npm -v
git init web-foundations && cd web-foundations && git add -A && git commit -m "init"
```

### Day 2: Semantic HTML: Structure a Page
- **Goal:** Build a semantic layout with header/nav/main/footer.
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>My Page</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>
    <header>
      <h1>Hello, Web!</h1>
      <nav>
        <a href="#home">Home</a>
        <a href="#about">About</a>
      </nav>
    </header>
    <main id="app">
      <section>
        <h2>Welcome</h2>
        <p>This is a semantic, accessible page.</p>
      </section>
    </main>
    <footer>&copy; 2025 You</footer>
    <script src="app.js"></script>
  </body>
</html>
```

### Day 3: CSS Basics + Box Model
- **Goal:** Practice padding/margin/border and typography.
```css
/* Try modifying box model props and observe layout */
.container { margin: 16px; padding: 16px; border: 2px dashed #aaa; }
```

### Day 4: Flexbox Essentials
- **Goal:** Create a responsive navbar + card row.
```css
/* styles.css */
:root { font-family: system-ui, sans-serif; }
* { box-sizing: border-box; }
body { margin: 0; }
header, footer { padding: 1rem; }
nav { display: flex; gap: 1rem; }
.main-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
  gap: 1rem;
  padding: 1rem;
}
.card {
  border: 1px solid #ddd;
  border-radius: 12px;
  padding: 1rem;
  box-shadow: 0 2px 6px rgba(0,0,0,0.06);
}
@media (prefers-color-scheme: dark) {
  body { background: #111; color: #eaeaea; }
  .card { border-color: #333; }
}
```

### Day 5: Grid Essentials
- **Goal:** Make a responsive grid gallery.
```css
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(160px, 1fr));
  gap: 12px;
}
.grid img { width: 100%; border-radius: 8px; }
```

### Day 6: JavaScript 101
- **Goal:** Variables, types, functions, arrow functions.
```js
const add = (a,b)=>a+b;
console.log(add(2,3));
```

### Day 7: Arrays, Objects, Looping
- **Goal:** Map/filter/reduce drills.
```js
const nums = [1,2,3,4];
const doubled = nums.map(n=>n*2);
const sum = nums.reduce((a,b)=>a+b,0);
console.log({ doubled, sum });
```

### Day 8: Async JS
- **Goal:** Promises, async/await.
```js
const delay = ms => new Promise(res => setTimeout(res, ms));
(async ()=>{ await delay(500); console.log('Done after 500ms'); })();
```

### Day 9: DOM Manipulation
- **Goal:** Create elements, events.
```js
// app.js
const app = document.getElementById('app');

function makeCard(title, body) {
  const div = document.createElement('div');
  div.className = 'card';
  div.innerHTML = `<h3>${title}</h3><p>${body}</p>`;
  return div;
}

['Learn HTML', 'Learn CSS', 'Learn JS'].forEach((t, i) => {
  app.appendChild(makeCard(t, `Step ${i+1} towards fullstack.`));
});
```

### Day 10: Fetch APIs
- **Goal:** GET a public API and render.
```js
// app.js
async function getWeather(city = 'London') {
  const resp = await fetch(`https://api.open-meteo.com/v1/forecast?latitude=51.5072&longitude=-0.1276&hourly=temperature_2m`);
  if (!resp.ok) throw new Error('Network error');
  const data = await resp.json();
  console.log('Sample data:', data.hourly?.temperature_2m?.slice(0, 5));
}
getWeather().catch(console.error);
```

### Day 11: Forms & Validation
- **Goal:** HTML5 validation + JS checks.
```js
document.querySelector('form').addEventListener('submit', (e)=>{
  const email = document.querySelector('#email').value;
  if(!/^[^@]+@[^@]+\.[^@]+$/.test(email)){ e.preventDefault(); alert('Invalid email'); }
});
```

### Day 12: Accessibility (a11y)
- **Goal:** Landmarks, aria-labels, contrast.
```html
<button aria-label="Close modal">×</button>
```

### Day 13: Responsive Design
- **Goal:** Media queries + mobile-first.
```css
@media (max-width: 480px){ .sidebar { display: none; } }
```

### Day 14: Mini-Project: Portfolio (Static)
- **Goal:** Ship a personal landing page.
```bash
# Use only HTML/CSS/JS. Commit & push.
```

### Day 15: CSS Architecture
- **Goal:** BEM or utility-first intro (Tailwind optional).
```html
<div class="card card--highlight">
  <h3 class="card__title">Title</h3>
  <p class="card__body">Body</p>
</div>
```

### Day 16: Tooling: npm scripts
- **Goal:** Automate dev tasks.
```json
// package.json
{ "scripts": { "dev": "live-server", "fmt": "prettier -w ." } }
```

### Day 17: ES Modules
- **Goal:** import/export basics.
```js
// math.js
export const mul = (a,b)=>a*b;
// app.js
import { mul } from './math.js';
console.log(mul(3,4));
```

### Day 18: State & Events (Vanilla)
- **Goal:** Simple stateful UI.
```js
let count = 0;
const btn = document.querySelector('#inc');
btn.addEventListener('click', ()=>{ count++; btn.textContent = `Count: ${count}`; });
```

### Day 19: LocalStorage
- **Goal:** Persist small state.
```js
const KEY='notes';
function save(notes){ localStorage.setItem(KEY, JSON.stringify(notes)); }
function load(){ return JSON.parse(localStorage.getItem(KEY) || '[]'); }
```

### Day 20: Mini-Project: Notes App (Vanilla)
- **Goal:** CRUD notes in localStorage.
```md
- Add, list, delete notes; persist to localStorage.
```

### Day 21: Intro to React + Vite
- **Goal:** Create app, understand components.
```bash
# Day start setup for React
npm create vite@latest my-react-app -- --template react
cd my-react-app
npm install
npm run dev
```

```jsx
// src/App.jsx
import { useState } from 'react';

export default function App() {
  const [items, setItems] = useState(['Read docs', 'Build UI']);
  const [text, setText] = useState('');
  return (
    <div style={{maxWidth: 720, margin: '40px auto', padding: 16}}>
      <h1>Todo</h1>
      <form onSubmit={(e)=>{e.preventDefault(); if(text) setItems([...items, text]); setText('');}}>
        <input value={text} onChange={e=>setText(e.target.value)} placeholder="Add item" />
        <button>Add</button>
      </form>
      <ul>
        {items.map((x,i)=>(
          <li key={i}>
            {x} <button onClick={()=>setItems(items.filter((_,j)=>j!==i))}>x</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
```

### Day 22: React Hooks (useState/useEffect)
- **Goal:** Fetch + render.
```jsx
import { useEffect, useState } from 'react';
export default function App(){
  const [data,setData]=useState([]);
  useEffect(()=>{
    fetch('https://jsonplaceholder.typicode.com/todos?_limit=5')
      .then(r=>r.json()).then(setData);
  },[]);
  return <ul>{data.map(d=><li key={d.id}>{d.title}</li>)}</ul>;
}
```

### Day 23: React Forms
- **Goal:** Controlled inputs.
```jsx
<input value={text} onChange={e=>setText(e.target.value)} />
```

### Day 24: React Router
- **Goal:** Basic routes.
```bash
npm i react-router-dom
```

```jsx
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
function Home(){ return <h2>Home</h2>; }
function About(){ return <h2>About</h2>; }
export default function App(){
  return (
    <BrowserRouter>
      <nav><Link to="/">Home</Link> | <Link to="/about">About</Link></nav>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/about" element={<About/>} />
      </Routes>
    </BrowserRouter>
  );
}
```

### Day 25: Styling with Tailwind (optional)
- **Goal:** Utility-first workflow.
```bash
# follow Tailwind docs for Vite
```

### Day 26: Component Composition
- **Goal:** Props, lifting state.
```jsx
function List({items,onRemove}){ return items.map((x,i)=><li key={i}>{x}<button onClick={()=>onRemove(i)}>x</button></li>) }
```

### Day 27: Mini-Project: React Todo
- **Goal:** CRUD in React only.
```md
- Add/remove items; persist to localStorage.
```

### Day 28: Project Polish
- **Goal:** Accessibility, error boundaries (basic).
```jsx
// Consider try/catch around async calls and fallback UI
```

### Day 29: Deploy React App
- **Goal:** Deploy to Vercel/Netlify.
```
# Vercel (frontend): vercel --prod
# Render (backend): connect Git repo, set start command, env vars, deploy
```

### Day 30: Month 1 Review
- **Goal:** Refactor, write README with learnings.
```md
- What went well?
- What was hard?
- What to repeat next month?
```


## Month 2 — Frontend Deep Dive (Days 31–60)

### Day 31: State Patterns
- **Goal:** Derived state, lifting, prop drilling vs context.
```jsx
import { createContext, useContext, useState } from 'react';
const Ctx = createContext();
function Provider({children}){
  const [theme, setTheme] = useState('light');
  return <Ctx.Provider value={{theme,setTheme}}>{children}</Ctx.Provider>;
}
function Use(){
  const { theme, setTheme } = useContext(Ctx);
  return <button onClick={()=>setTheme(t=>t==='light'?'dark':'light')}>{theme}</button>;
}
```

### Day 32: Data Fetching Patterns
- **Goal:** Loading/error/empty states.
```jsx
if(loading) return <p>Loading...</p>;
if(error) return <p role="alert">Failed</p>;
if(!data.length) return <p>No items.</p>;
```

### Day 33: Performance Basics
- **Goal:** Memoization, keying, list rendering.
```jsx
import { useMemo } from 'react';
const filtered = useMemo(()=> items.filter(x=>x.done), [items]);
```

### Day 34: Forms: React Hook Form (optional)
- **Goal:** Better forms.
```bash
npm i react-hook-form
```

```jsx
import { useForm } from 'react-hook-form';
const { register, handleSubmit } = useForm();
<form onSubmit={handleSubmit(console.log)}>
  <input {...register('email', { required: true })} />
  <button>Submit</button>
</form>
```

### Day 35: UI Libraries
- **Goal:** Headless UI, Radix, shadcn/ui (conceptual).
```md
- Pick one for accessible components.
```

### Day 36: Testing React
- **Goal:** Unit testing with React Testing Library.
```bash
npm i -D @testing-library/react @testing-library/jest-dom
```

### Day 37: Accessibility Pass
- **Goal:** Keyboard nav, focus traps.
```md
- Ensure tab order and visible focus styles.
```

### Day 38: Mini-Project: Recipe Finder
- **Goal:** Search public API, list + detail view.
```md
- Build cards + details route.
```

### Day 39: Polish + Deploy
- **Goal:** Bundle analysis, lazy routes.
```jsx
const Detail = React.lazy(()=>import('./Detail'));
```

### Day 40: Review
- **Goal:** Readme + screenshots.
```md
- Add project screenshots to README.
```

### Day 41: TypeScript Intro
- **Goal:** Convert components to TS.
```bash
npm i -D typescript @types/react @types/react-dom
```

### Day 42: Error Handling Patterns
- **Goal:** Error boundaries.
```jsx
class ErrorBoundary extends React.Component{ /* ... */ }
```

### Day 43: Routing Advanced
- **Goal:** Nested, params, loaders (if using Remix/Next).

### Day 44: State Management
- **Goal:** Evaluate Redux/Zustand/Context.
```bash
npm i zustand
```

### Day 45: Design Systems
- **Goal:** Tokens, theming.

### Day 46: Animations
- **Goal:** Framer Motion basics.
```bash
npm i framer-motion
```

### Day 47: Internationalization
- **Goal:** i18n routing/strings.

### Day 48: Performance II
- **Goal:** Code splitting, Suspense.

### Day 49: Mini-Project: Dashboard
- **Goal:** Charts + filters.

### Day 50: Deploy & Docs
- **Goal:** Deploy dashboard + write docs.

### Day 51: Month 2 Buffer
- **Goal:** Catch-up/refactor.

### Day 52: Review
- **Goal:** What did you learn?

### Day 53: Preview Month 3
- **Goal:** Backend prep.

### Day 54: CLI Comfort
- **Goal:** Shell scripts for dev tasks.
```bash
echo 'alias dev="npm run dev"' >> ~/.bashrc
```

### Day 55: HTTP Deep Dive
- **Goal:** Caching, status codes.

### Day 56: Security on Frontend
- **Goal:** XSS/CSRF basics.

### Day 57: Forms Advanced
- **Goal:** Debounce, optimistic UI.
```js
let t; function set(v){ clearTimeout(t); t=setTimeout(()=>save(v),300); }
```

### Day 58: File Uploads
- **Goal:** Handle file inputs to API.

### Day 59: End of Month 2 Review
- **Goal:** Summarize and plan.


## Month 3 — Backend Fundamentals (Days 61–90)

### Day 61: Express API Setup
- **Goal:** Scaffold API + health check.
```bash
mkdir api && cd api
npm init -y
npm i express cors morgan
npm i -D nodemon
```

```json
// package.json (scripts)
{
  "scripts": {
    "dev": "nodemon index.js",
    "start": "node index.js"
  }
}
```

```js
// index.js
const express = require('express');
const morgan = require('morgan');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());
app.use(morgan('dev'));

app.get('/health', (req, res) => res.json({ ok: true }));

let todos = [{ id: 1, text: 'Setup API' }];

app.get('/todos', (req, res) => res.json(todos));
app.post('/todos', (req, res) => {
  const todo = { id: Date.now(), text: req.body.text || '' };
  todos.push(todo);
  res.status(201).json(todo);
});

app.listen(3000, () => console.log('API on http://localhost:3000'));
```

### Day 62: Routing & Middleware
- **Goal:** Routers, 404 handler, error handler.
```js
app.use((req,res,next)=>{ res.status(404).json({error:'Not found'}); });
app.use((err,req,res,next)=>{ console.error(err); res.status(500).json({error:'Server'}); });
```

### Day 63: CRUD: In‑Memory
- **Goal:** Implement CRUD endpoints.
```js
// add PUT /todos/:id and DELETE /todos/:id
```

### Day 64: PostgreSQL Setup
- **Goal:** Connect + run migrations.
```bash
npm i pg
```

```js
// db.js
const { Pool } = require('pg');
const pool = new Pool({
  connectionString: process.env.DATABASE_URL || 'postgres://postgres:postgres@localhost:5432/todos'
});
module.exports = { query: (text, params) => pool.query(text, params) };
```

```js
// index.js (snippet)
const db = require('./db');
app.get('/items', async (req, res) => {
  const { rows } = await db.query('SELECT id, title, done FROM items ORDER BY id DESC');
  res.json(rows);
});
```

### Day 65: SQL Modeling
- **Goal:** Design tables + indexes.
```sql
CREATE TABLE items(id SERIAL PRIMARY KEY, title TEXT NOT NULL, done BOOLEAN DEFAULT false);
CREATE INDEX ON items(done);
```

### Day 66: MongoDB Setup (Alt)
- **Goal:** Connect + create model.
```bash
npm i mongoose
```

```js
// models/Todo.js
const mongoose = require('mongoose');
const TodoSchema = new mongoose.Schema({
  text: { type: String, required: true },
  done: { type: Boolean, default: false }
}, { timestamps: true });
module.exports = mongoose.model('Todo', TodoSchema);
```

### Day 67: Validation
- **Goal:** Validate inputs with zod/yup.
```bash
npm i zod
```

```js
const { z } = require('zod');
const schema = z.object({ text: z.string().min(1) });
```

### Day 68: Auth Basics
- **Goal:** Hash passwords + login.
```bash
npm i jsonwebtoken bcryptjs
```

```js
// auth.js
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');

const JWT_SECRET = process.env.JWT_SECRET || 'dev_secret';

async function hash(pw){ return bcrypt.hash(pw, 10); }
async function compare(pw, hash){ return bcrypt.compare(pw, hash); }
function sign(payload){ return jwt.sign(payload, JWT_SECRET, { expiresIn: '7d' }); }
function verify(token){ return jwt.verify(token, JWT_SECRET); }

module.exports = { hash, compare, sign, verify };
```

### Day 69: Protect Routes
- **Goal:** JWT middleware.
```js
function auth(req,res,next){
  const token = (req.headers.authorization||'').replace('Bearer ','').trim();
  try { req.user = require('./auth').verify(token); next(); }
  catch { res.status(401).json({error:'unauthorized'}); }
}
```

### Day 70: Testing API
- **Goal:** Jest + Supertest.
```bash
npm i -D jest supertest
```

```js
// app.js
const express = require('express');
const app = express();
app.get('/health', (req,res)=>res.json({ok:true}));
module.exports = app;
```

```js
// app.test.js
const request = require('supertest');
const app = require('./app');

test('health ok', async () => {
  const res = await request(app).get('/health');
  expect(res.status).toBe(200);
  expect(res.body.ok).toBe(true);
});
```

```json
// package.json (scripts)
{
  "scripts": {
    "test": "jest"
  }
}
```

### Day 71: Pagination & Filtering
- **Goal:** limit/offset, query params.
```js
const limit = Math.min(+req.query.limit||20, 100);
const offset = +req.query.offset||0;
```

### Day 72: Sorting & Search
- **Goal:** ORDER BY; text search.

### Day 73: File Uploads
- **Goal:** multer + S3 stub.
```bash
npm i multer
```

### Day 74: WebSockets Intro
- **Goal:** socket.io basics.
```bash
npm i socket.io
```

### Day 75: Rate Limiting
- **Goal:** Helmet/rate-limit.
```bash
npm i helmet express-rate-limit
```

### Day 76: Docs
- **Goal:** OpenAPI/Swagger.
```bash
npm i swagger-ui-express swagger-jsdoc
```

### Day 77: Email
- **Goal:** Nodemailer (dev transport).
```bash
npm i nodemailer
```

### Day 78: Background Jobs
- **Goal:** Agenda/Bull basics.

### Day 79: Observability
- **Goal:** morgan logs + basic metrics.

### Day 80: Deploy API (Dev)
- **Goal:** Deploy to Render.
```
# Vercel (frontend): vercel --prod
# Render (backend): connect Git repo, set start command, env vars, deploy
```

### Day 81: Month 3 Review
- **Goal:** Refactor + docs.


## Month 4 — Frontend + Backend Together (Days 91–120)

### Day 91: Connect React to API
- **Goal:** CORS + fetch live data.
```js
fetch('http://localhost:3000/todos').then(r=>r.json()).then(setTodos);
```

### Day 92: Auth in Frontend
- **Goal:** Login form + store token.
```js
localStorage.setItem('token', token);
```

### Day 93: Protected Routes (FE)
- **Goal:** Require auth to view pages.
```jsx
// if(!token) return <Navigate to="/login" replace />
```

### Day 94: Forms to API
- **Goal:** Create/Update via POST/PUT.

### Day 95: Error & Retry
- **Goal:** Handle network failures.

### Day 96: Realtime Updates
- **Goal:** socket.io client + server.
```js
// client: const socket = io(API_URL); socket.on('new_todo', addTodo);
```

### Day 97: Mini-Project: Blog Fullstack
- **Goal:** Posts CRUD + auth + comments.

### Day 98: Mini-Project Polish
- **Goal:** Accessibility + tests.

### Day 99: Deploy Both
- **Goal:** FE to Vercel, API to Render.
```
# Vercel (frontend): vercel --prod
# Render (backend): connect Git repo, set start command, env vars, deploy
```

### Day 100: Review
- **Goal:** Docs + screenshots.

### Day 101: Caching
- **Goal:** Client caching + HTTP caching.

### Day 102: Optimistic UI
- **Goal:** Update UI before server responds.

### Day 103: Error Boundaries (FE/BE)
- **Goal:** Holistic failure paths.

### Day 104: Feature Flags
- **Goal:** Env-based toggles.

### Day 105: Mini-Project: Chat (WS)
- **Goal:** Channels + presence.

### Day 106: File Upload Pipeline
- **Goal:** Preview, progress bars.

### Day 107: Accessibility Review
- **Goal:** Keyboard, screen readers.

### Day 108: E2E Tests
- **Goal:** Playwright/Cypress intro.

### Day 109: Monitoring
- **Goal:** Frontend web vitals + API logs.

### Day 110: Month 4 Review
- **Goal:** Ship blog + chat demos.


## Month 5 — Advanced Topics (Days 121–150)

### Day 121: GraphQL Intro
- **Goal:** Schema, resolver, query.
```bash
npm i graphql express-graphql
```

### Day 122: Third-Party APIs
- **Goal:** Stripe sandbox integration.
```bash
npm i stripe
```

### Day 123: Search
- **Goal:** Add search endpoint + DB index.

### Day 124: Caching Layer
- **Goal:** Redis basics for caching.
```bash
npm i ioredis
```

### Day 125: Testing Strategy
- **Goal:** Unit, integration, e2e plan.

### Day 126: Security
- **Goal:** OWASP Top 10 walkthrough.

### Day 127: Scaling Basics
- **Goal:** Stateless services, DB constraints.

### Day 128: Mini-Project: E‑commerce
- **Goal:** Products/cart CRUD.

### Day 129: Payments
- **Goal:** Stripe checkout flow (test keys).

### Day 130: Deploy + Docs
- **Goal:** Ship ecommerce demo.

### Day 131: Review
- **Goal:** Stabilize and write postmortem.

### Day 132: CI/CD
- **Goal:** GitHub Actions basic pipeline.
```yaml
name: ci
on: [push]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-node@v4
        with: { node-version: 20 }
      - run: npm ci
      - run: npm test --workspaces --if-present
```

### Day 133: Docker Compose (DB + API)
- **Goal:** Compose dev stack.
```dockerfile
# Dockerfile
FROM node:20-alpine
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
```

```yaml
# docker-compose.yml
services:
  api:
    build: .
    ports:
      - "3000:3000"
    environment:
      - NODE_ENV=production
```

### Day 134: Infra as Code (light)
- **Goal:** Define env in code.

### Day 135: Monitoring/Logging
- **Goal:** Winston logs, error tracking.
```bash
npm i winston
```

### Day 136: Feature Toggles
- **Goal:** Config-driven releases.

### Day 137: A/B Testing Basics
- **Goal:** Buckets + metrics.

### Day 138: Month 5 Review
- **Goal:** Polish ecommerce.

### Day 139: Capstone Prep
- **Goal:** Select final project scope.


## Month 6 — Capstone Project (Days 151–180)

### Day 151: Capstone Kickoff
- **Goal:** Pick project (Trello‑like recommended). Define MVP.
```md
MVP: Boards, lists, cards, auth, realtime updates.
```

### Day 152: System Design
- **Goal:** Entity models, API routes, components.
```md
Entities: User, Board, List, Card, Activity.
```

### Day 153: Repo + Monorepo (optional)
- **Goal:** Setup FE/BE workspaces.
```bash
npm i -g turbo # or use pnpm workspaces
```

### Day 154: Auth Flow
- **Goal:** Signup/login + JWT + protected routes.

### Day 155: Boards CRUD (API)
- **Goal:** Create/read/update/delete boards.

### Day 156: Boards UI
- **Goal:** Boards page + create dialog.

### Day 157: Lists + Cards (API)
- **Goal:** CRUD lists and cards.

### Day 158: Lists + Cards UI
- **Goal:** Drag & drop + reordering.
```bash
npm i @dnd-kit/core
```

### Day 159: Realtime Channels
- **Goal:** socket.io rooms per board.

### Day 160: Activity Log
- **Goal:** Record actions server‑side.

### Day 161: Comments & Mentions
- **Goal:** Card comments, @mentions.

### Day 162: File Attachments
- **Goal:** Upload files to cards.

### Day 163: Search & Filters
- **Goal:** Query params, server filters.

### Day 164: Notifications
- **Goal:** Email/in‑app basic notifications.

### Day 165: Testing Pass
- **Goal:** API + UI tests on critical paths.

### Day 166: Accessibility Pass
- **Goal:** Keyboard, ARIA roles.

### Day 167: Performance Pass
- **Goal:** Lazy load, pagination.

### Day 168: Security Pass
- **Goal:** Audit deps, headers, auth rules.

### Day 169: Prepare Deploy
- **Goal:** Dockerize, env vars, DB migrations.
```dockerfile
# Dockerfile
FROM node:20-alpine
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
EXPOSE 3000
CMD ["npm", "start"]
```

```yaml
# docker-compose.yml
services:
  api:
    build: .
    ports:
      - "3000:3000"
    environment:
      - NODE_ENV=production
```

### Day 170: Staging Deploy
- **Goal:** Stage on Render/Vercel, manual QA.
```
# Vercel (frontend): vercel --prod
# Render (backend): connect Git repo, set start command, env vars, deploy
```

### Day 171: Bug Bash
- **Goal:** Fix defects from QA.

### Day 172: Analytics
- **Goal:** Basic events + KPIs.

### Day 173: Docs
- **Goal:** README, architecture, runbooks.

### Day 174: Production Deploy
- **Goal:** Cut release + announce.

### Day 175: Postmortem
- **Goal:** What went well/poorly.

### Day 176: Polish & Refactor
- **Goal:** Code cleanup, DX tweaks.

### Day 177: Resume & Portfolio
- **Goal:** Add links, screenshots, write case study.

### Day 178: Interview Prep
- **Goal:** Behavioral + system design notes.

### Day 179: Open Source Day
- **Goal:** Open PRs to libraries/docs.

### Day 180: Wrap‑Up
- **Goal:** Plan next 3 months.
```md
- Deepen in one backend language (Go/Java), or scale React skills.
```
