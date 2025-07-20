# 🎯 **TuneTray - a music playlist app**

---

## 🟢 **1️⃣ Backend: Spring Boot (API & Data)**

### ✅ Project Setup

- Create Spring Boot app (Spring Initializr)  
  Dependencies: `Spring Web`, `Spring Data JPA`, `H2 Database`

**⚠️ NOTE:** This app is delivered in demo mode. The H2 database runs **in-memory**, not from a file, so all data will be wiped when the application closes. To enable persistent data, update the H2 configuration to use a file-based database.

### ✅ Define Entities

- `Track`: `id`, `title`, `artist`, `album`

- `Playlist`: `id`, `name`, `List<Track>`

### ✅ Setup Repositories

- `TrackRepository`: `findAll()`

- `PlaylistRepository`: `findAll()`, `save()`, `deleteById()`

### ✅ Create Basic API (Controllers)

| Endpoint              | Method | Purpose         |
| --------------------- | ------ | --------------- |
| `/api/tracks`         | GET    | List tracks     |
| `/api/playlists`      | GET    | List playlists  |
| `/api/playlists`      | POST   | Create playlist |
| `/api/playlists/{id}` | DELETE | Delete playlist |

### ✅ Seed Sample Data (CommandLineRunner or data.sql)

### ✅ Test with Postman / Swagger

**✔️ Backend Complete (~5-6 hours)**

---

## 🟡 **2️⃣ Frontend: Angular (UI & Integration)**

### ✅ Project Setup

- `ng new music-playlist-app`

- Install Angular Material or Tailwind CSS (optional)

### ✅ App Structure

| Component               | Purpose                         |
| ----------------------- | ------------------------------- |
| `TrackListComponent`    | Show available tracks           |
| `PlaylistComponent`     | Create/manage a single playlist |
| `PlaylistListComponent` | View all saved playlists        |

### ✅ Services (HTTP)

- `TrackService`: `getTracks()`

- `PlaylistService`: `getPlaylists()`, `createPlaylist()`, `deletePlaylist()`

---

### ✅ Implement Features

1. Fetch and display tracks from API

2. Create playlists (select tracks, name, submit)

3. View saved playlists

4. Delete playlists

5. Polish UI with Material/Tailwind (optional)

---

## 🔵 **3️⃣ Finishing Touches**

### ✅ Polish UX/UI

- Loading indicators

- Confirmation dialogs

- Minimal animations/transitions (optional)

### ✅ Basic Testing

- Manual checks for CRUD flow

- API error handling (404, etc.)

---

# 🚩 **Final Deliverables**

- Clean repo: `/backend` (Spring Boot) + `/frontend` (Angular)

- README with instructions

- Screenshots (optional) for your portfolio
