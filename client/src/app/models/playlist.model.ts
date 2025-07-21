import type { Track } from "./track.model";

// Represents a playlist entity with its related tracks
export interface Playlist {
	id: number;
	name: string;
	description: string;
	tracks: Track[]; // A playlist contains multiple tracks
}
