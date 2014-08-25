package wechat4j.support;

import java.io.File;

/**
 * UploadMedia
 *
 * @author renbin.fang.
 * @date 2014/8/25.
 */
public abstract class AbstractUploadMedia {
    public abstract String uploadMedia(File mediaFile, String accessToken, String type);

    public abstract String downloadMedia(String accessToken, String mediaId);

    public enum MediaType {
        IMAGE, VOICE, VIDEO, THUMB;
    }
}
