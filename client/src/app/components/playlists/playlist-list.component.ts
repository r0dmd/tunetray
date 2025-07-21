// biome-ignore lint/style/useImportType: <Angular>
import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
// biome-ignore lint/style/useImportType: <Angular>
import { PlaylistService } from "../../services/playlist.service";
import type { Playlist } from "../../models/playlist.model";

@Component({
	selector: "app-playlist-list",
	standalone: true, // No module required
	imports: [CommonModule], // For *ngFor, *ngIf, etc.
	template: `
  <main class="relative min-h-screen p-8 w-full mx-auto flex flex-col gap-6 bg-gradient-to-br from-indigo-950 via-indigo-900 to-purple-950 text-white shadow-lg overflow-hidden">

  <!-- Optional shimmer effect for subtle background movement -->
  <div class="absolute inset-0 bg-gradient-to-r from-transparent via-white/5 to-transparent animate-shimmer opacity-20 pointer-events-none"></div>

  <div class="relative max-w-5xl mx-auto flex gap-2 flex-col z-10">

    <button
      class="self-start bg-green-500/40 hover:bg-green-400/40 transition px-4 py-2 rounded-lg text-sm font-semibold shadow-md">
      + Add New Playlist
    </button>

    <ul class="space-y-4 mb-10">
      <li *ngFor="let playlist of playlists"
          class="p-4 rounded-lg bg-indigo-900/50 border border-white/10 shadow-md hover:shadow-lg transition flex justify-between items-center">
        <div>
          <div class="font-semibold text-indigo-100">{{ playlist.name }}</div>
          <div class="text-indigo-300 text-sm">{{ playlist.description }}</div>
          <div class="text-indigo-400 text-xs mt-1">Contains {{ playlist.tracks.length }} track(s)</div>
        </div>
        <div class="flex gap-2 ml-10">
          <button
            class="px-3 py-1 rounded-md bg-indigo-500/30 hover:bg-indigo-500/50 transition text-indigo-100 text-sm">
            Edit
          </button>
          <button
            class="px-3 py-1 rounded-md bg-red-500/30 hover:bg-red-500/50 transition text-red-100 text-sm">
            Delete
          </button>
        </div>
      </li>
    </ul>
  </div>
</main>

  `,
})
export class PlaylistListComponent implements OnInit {
	playlists: Playlist[] = [];

	constructor(private playlistService: PlaylistService) {}

	ngOnInit(): void {
		this.playlistService.getPlaylists().subscribe({
			next: (data) => {
				this.playlists = data;
			},
			error: (err) => console.error("Failed to load playlists", err),
		});
	}
}
