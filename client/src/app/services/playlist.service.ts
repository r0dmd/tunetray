import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import type { Playlist } from "../models/playlist.model";

// HTTP methods to interact with the Playlist API
@Injectable({
	providedIn: "root",
})
export class PlaylistService {
	private apiUrl = "http://localhost:8080/api/playlists";

	constructor(private http: HttpClient) {}

	getPlaylists(): Observable<Playlist[]> {
		return this.http.get<Playlist[]>(this.apiUrl);
	}
}
