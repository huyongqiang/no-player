package com.novoda.noplayer.exoplayer.forwarder;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.novoda.noplayer.exoplayer.forwarder.ExoPlayerForwarder;

import java.io.IOException;

/**
 * A listener for internal errors.
 * <p>
 * These errors are not visible to the user, and hence this listener is provided for
 * informational purposes only. Note however that an internal error may cause a fatal
 * error if the player fails to recover. If this happens, {@link ExoPlayerForwarder#forwardPlayerError(ExoPlaybackException)}
 * will be invoked.
 */
public interface InternalErrorListener {

    // TODO: Add additional logging when developing DRM.
    void onLoadError(IOException e);
}