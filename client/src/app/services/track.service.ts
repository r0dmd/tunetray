// biome-ignore lint/style/useImportType: <Angular Dependency Injection is not type-only. Angular needs the real class, not just the type info because it uses the class itself as the injection token at runtime.>
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import type { Observable } from "rxjs";
import type { Track } from "../models/track.model.ts";

@Injectable({
	providedIn: "root", // Singleton service available app-wide
})
export class TrackService {
	private baseUrl = "http://localhost:8080/api/tracks";

	constructor(private http: HttpClient) {}

	getTracks(): Observable<Track[]> {
		return this.http.get<Track[]>(this.baseUrl);
	}

	getTrack(id: number): Observable<Track> {
		return this.http.get<Track>(`${this.baseUrl}/${id}`);
	}

	createTrack(track: Track): Observable<Track> {
		return this.http.post<Track>(this.baseUrl, track);
	}

	updateTrack(track: Track): Observable<Track> {
		return this.http.put<Track>(`${this.baseUrl}/${track.id}`, track);
	}

	deleteTrack(id: number): Observable<void> {
		return this.http.delete<void>(`${this.baseUrl}/${id}`);
	}
}
