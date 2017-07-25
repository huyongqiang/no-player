package com.novoda.noplayer.internal.exoplayer.forwarder;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.novoda.noplayer.Player;

class BufferStateForwarder implements ExoPlayer.EventListener {

    private final Player.BufferStateListener bufferStateListener;

    BufferStateForwarder(Player.BufferStateListener bufferStateListener) {
        this.bufferStateListener = bufferStateListener;
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        if (playbackState == ExoPlayer.STATE_BUFFERING) {
            bufferStateListener.onBufferStarted();
        } else if (playbackState == ExoPlayer.STATE_READY) {
            bufferStateListener.onBufferCompleted();
        }
    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest) {
        //TODO should we send ?
    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        //TODO should we send ?
    }

    @Override
    public void onLoadingChanged(boolean isLoading) {
        //TODO should we send ?
    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {
        //Sent by ErrorForwarder
    }

    @Override
    public void onPositionDiscontinuity() {
        //TODO should we send ?
    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        //TODO should we send ?
    }
}