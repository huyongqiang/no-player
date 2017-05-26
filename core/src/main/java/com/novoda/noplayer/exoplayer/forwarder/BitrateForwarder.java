package com.novoda.noplayer.exoplayer.forwarder;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.novoda.noplayer.listeners.BitrateChangedListeners;

import java.io.IOException;

class BitrateForwarder implements AdaptiveMediaSourceEventListener {

    private Bitrate videoBitrate = Bitrate.fromBitsPerSecond(0);  //Check if same logic in MediaPlayer
    private Bitrate audioBitrate = Bitrate.fromBitsPerSecond(0);

    private final BitrateChangedListeners bitrateChangedListeners;

    BitrateForwarder(BitrateChangedListeners bitrateChangedListeners) {
        this.bitrateChangedListeners = bitrateChangedListeners;
    }

    @Override
    public void onDownstreamFormatChanged(int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaTimeMs) {
        if (trackType == C.TRACK_TYPE_VIDEO) {
            videoBitrate = Bitrate.fromBitsPerSecond(trackFormat.bitrate);
            bitrateChangedListeners.onBitrateChanged(audioBitrate, videoBitrate);
        } else if (trackType == C.TRACK_TYPE_AUDIO) {
            audioBitrate = Bitrate.fromBitsPerSecond(trackFormat.bitrate);
            bitrateChangedListeners.onBitrateChanged(audioBitrate, videoBitrate);
        }
    }

    @Override
    public void onLoadStarted(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs, long elapsedRealtimeMs) {
        //TODO should we send ?
    }

    @Override
    public void onLoadCompleted(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
        //TODO should we send ?
    }

    @Override
    public void onLoadCanceled(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded) {
        //TODO should we send ?
    }

    @Override
    public void onLoadError(DataSpec dataSpec, int dataType, int trackType, Format trackFormat, int trackSelectionReason, Object trackSelectionData, long mediaStartTimeMs, long mediaEndTimeMs, long elapsedRealtimeMs, long loadDurationMs, long bytesLoaded, IOException error, boolean wasCanceled) {
        //TODO should we send ?
    }

    @Override
    public void onUpstreamDiscarded(int trackType, long mediaStartTimeMs, long mediaEndTimeMs) {
        //TODO should we send ?
    }
}