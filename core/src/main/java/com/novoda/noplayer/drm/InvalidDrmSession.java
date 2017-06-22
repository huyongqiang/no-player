package com.novoda.noplayer.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;

import java.util.Map;

class InvalidDrmSession implements FrameworkDrmSession {

    private final DrmSessionException drmSessionException;

    InvalidDrmSession(DrmSessionException drmSessionException) {
        this.drmSessionException = drmSessionException;
    }

    @Override
    public int getState() {
        return DrmSession.STATE_ERROR;
    }

    @Override
    public FrameworkMediaCrypto getMediaCrypto() {
        throw new IllegalStateException();
    }

    @Override
    public boolean requiresSecureDecoderComponent(String mimeType) {
        throw new IllegalStateException();
    }

    @Override
    public DrmSessionException getError() {
        return drmSessionException;
    }

    @Override
    public Map<String, String> queryKeyStatus() {
        throw new IllegalStateException();
    }

    @Override
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override
    public byte[] getSessionId() {
        return new byte[0];
    }
}