// biome-ignore lint/style/useImportType: <Angular>
import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common"; // <-- import CommonModule here
import type { Track } from "../../models/track.model";
// biome-ignore lint/style/useImportType: <Angular>
import { TrackService } from "../../services/track.service";
import { TrackFormComponent } from "./track-form.component";

@Component({
	selector: "app-track-list",
	standalone: true,
	imports: [CommonModule, TrackFormComponent],
	template: `
   <main class="relative min-h-screen p-8 w-full mx-auto flex flex-col gap-6 bg-gradient-to-br from-indigo-950 via-indigo-900 to-purple-950 text-white shadow-lg overflow-hidden">

  <div class="absolute inset-0 bg-gradient-to-r from-transparent via-white/5 to-transparent animate-shimmer opacity-20 pointer-events-none"></div>

  <div class="relative max-w-5xl mx-auto flex gap-2 flex-col z-10">

    <button
      (click)="startCreate()"
      class="self-start bg-green-500/40 hover:bg-green-400/40 transition px-4 py-2 rounded-lg text-sm font-semibold shadow-md">
      + Add New Track
    </button>

    <app-track-form
      *ngIf="editingTrack"
      [track]="editingTrack"
      (save)="saveTrack($event)"
      (cancel)="cancelEdit()"
    ></app-track-form>

    <ul class="space-y-4 mb-10">
      <li *ngFor="let track of tracks"
          class="p-4 rounded-lg bg-indigo-900/50 border border-white/10 shadow-md hover:shadow-lg transition flex justify-between items-center">
        <div>
          <div class="font-semibold text-indigo-100">{{ track.title }}</div>
          <div class="text-indigo-300 text-sm">{{ track.artist }} — {{ track.album }}</div>
        </div>
        <div class="flex gap-2 ml-2">
          <button
            (click)="editTrack(track)"
            class="px-3 py-1 rounded-md bg-indigo-500/30 hover:bg-indigo-500/50 transition text-indigo-100 text-sm">
            Edit
          </button>
          <button
            (click)="deleteTrack(track.id!)"
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
export class TrackListComponent implements OnInit {
	tracks: Track[] = [];
	editingTrack: Track | null = null;

	constructor(private trackService: TrackService) {}

	ngOnInit(): void {
		this.loadTracks();
	}

	loadTracks() {
		this.trackService.getTracks().subscribe((tracks) => {
			this.tracks = tracks;
		});
	}

	startCreate() {
		this.editingTrack = { title: "", artist: "", album: "" };
	}

	editTrack(track: Track) {
		this.editingTrack = { ...track };
	}

	saveTrack(track: Track) {
		if (track.id && track.id !== 0) {
			this.trackService.updateTrack(track).subscribe(() => {
				this.loadTracks();
				this.editingTrack = null;
			});
		} else {
			this.trackService.createTrack(track).subscribe(() => {
				this.loadTracks();
				this.editingTrack = null;
			});
		}
	}

	cancelEdit() {
		this.editingTrack = null;
	}

	deleteTrack(id: number) {
		if (confirm("Are you sure you want to delete this track?")) {
			this.trackService.deleteTrack(id).subscribe(() => this.loadTracks());
		}
	}
}
