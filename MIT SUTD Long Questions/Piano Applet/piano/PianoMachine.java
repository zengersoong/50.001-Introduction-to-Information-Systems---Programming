

package piano;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;
import midi.Instrument;
import music.NoteEvent;
import music.NoteEvent.Kind;

public class PianoMachine {

	private Midi midi;
	int pitch_Adj = 0;
	Instrument currentInstrument;
	boolean recording = false;
	ArrayList<NoteEvent> recordTrack;
	Hashtable<Pitch, Boolean> playingPitch; //stores current active pitches

	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
	public PianoMachine() {
		try {
			midi = Midi.getInstance();
			currentInstrument = Instrument.PIANO;
			recordTrack = new ArrayList<NoteEvent>();
			playingPitch = new Hashtable<Pitch, Boolean>();
		} catch (MidiUnavailableException e1) {
			System.err.println("Could not initialize midi device");
			e1.printStackTrace();
			return;
		}
	}

	public void beginNote(Pitch rawPitch) {

		// midi.beginNote(new Pitch(0).toMidiFrequency());
		if (playingPitch.containsKey(rawPitch))
			return; // already playing this pitch

		playingPitch.put(rawPitch, true); // store this pitch as playing
		midi.beginNote(rawPitch.toMidiFrequency() + pitch_Adj, currentInstrument);

		if (recording) {
			recordTrack.add(new NoteEvent(rawPitch, System.currentTimeMillis(), currentInstrument, Kind.start));
		}
		return;

	}
	// Try using Date().getTime/10 instead.

	public void endNote(Pitch rawPitch) {

		// midi.endNote(new Pitch(0).toMidiFrequency());
		midi.endNote(rawPitch.toMidiFrequency() + pitch_Adj, currentInstrument);
		playingPitch.remove(rawPitch); // remove this pitch from the playing list

		if (recording) {
			recordTrack.add(new NoteEvent(rawPitch, System.currentTimeMillis(), currentInstrument, Kind.stop));
		}
	}

	public void changeInstrument() {
		currentInstrument = currentInstrument.next();
	}

	// write method spec
	public void shiftUp() {
		if ((pitch_Adj < 24)) {
			pitch_Adj += 12;
		}

	}

	// write method spec
	public void shiftDown() {

		if ((pitch_Adj > -24)) {
			pitch_Adj -= 12;

		}
	}

	// write method spec
	public boolean toggleRecording() {
		if (!recording) {
			recording = true;
			recordTrack.clear();
		} else {
			recording = false;
		}
		return recording;

		// : implement for question 4
	}

	// write method spec
	public void playback() {
		if (recordTrack.isEmpty())
			return;
		else {
			long lasttime = recordTrack.get(0).getTime();
			for (NoteEvent evt : recordTrack) {
				long interval = evt.getTime() - lasttime;
				try {
					Thread.sleep(interval);
					if (evt.getKind() == Kind.start)
						midi.beginNote(evt.getPitch().toMidiFrequency(), currentInstrument);
					else
						midi.endNote(evt.getPitch().toMidiFrequency(), currentInstrument);

					lasttime = evt.getTime();

				} catch (InterruptedException e) {
					return;

				}
			}

		}
		// : implement for question 4
	}

}