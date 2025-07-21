import { Component, EventEmitter, Input, Output } from "@angular/core";
import type { Track } from "../../models/track.model";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@Component({
	selector: "app-track-form",
	standalone: true,
	imports: [CommonModule, FormsModule],
	template: `
    <form (ngSubmit)="submit()"
      class="space-y-4 p-6 rounded-xl bg-black/30 backdrop-blur-md text-white max-w-md mx-auto shadow-lg">

  <label class="block text-sm font-semibold text-indigo-200">
    Title:
    <input type="text"
           [(ngModel)]="track.title"
           name="title"
           required
           class="mt-1 block w-full rounded-md bg-white/10 border border-white/20 p-2 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition" />
  </label>

  <label class="block text-sm font-semibold text-indigo-200">
    Artist:
    <input type="text"
           [(ngModel)]="track.artist"
           name="artist"
           required
           class="mt-1 block w-full rounded-md bg-white/10 border border-white/20 p-2 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition" />
  </label>

  <label class="block text-sm font-semibold text-indigo-200">
    Album:
    <input type="text"
           [(ngModel)]="track.album"
           name="album"
           required
           class="mt-1 block w-full rounded-md bg-white/10 border border-white/20 p-2 text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-indigo-500 transition" />
  </label>

  <div class="flex gap-4 mt-4">
    <button type="submit"
            class="bg-green-500/40 hover:bg-green-400/40 transition px-4 py-2 rounded-lg text-sm font-semibold shadow-md">
      {{ track.id ? 'Update' : 'Create' }}
    </button>
    <button type="button"
            (click)="cancel.emit()"
            class="px-4 py-2 rounded-lg bg-white/10 hover:bg-white/20 text-sm text-indigo-200 transition">
      Cancel
    </button>
  </div>
</form>

  `,
})
export class TrackFormComponent {
	@Input() track: Track = { title: "", artist: "", album: "" };
	@Output() save = new EventEmitter<Track>();
	@Output() cancel = new EventEmitter<void>();

	submit() {
		this.save.emit(this.track);
	}
}
