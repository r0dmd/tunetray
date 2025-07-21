import type { Routes } from "@angular/router";
import { TrackListComponent } from "./components/tracks/track-list.component";
import { PlaylistListComponent } from "./components/playlists/playlist-list.component";

export const routes: Routes = [
	{ path: "", component: TrackListComponent },
	{ path: "playlists", component: PlaylistListComponent },
];
