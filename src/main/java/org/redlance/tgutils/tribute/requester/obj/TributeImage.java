package org.redlance.tgutils.tribute.requester.obj;

/**
 * @param id Id
 * @param path Image url
 * @param thumbnail Base64 encoded image
 * @param width Image width
 * @param height Image height
 */
public record TributeImage(int id, String path, String thumbnail, int width, int height) {
    @Override
    public String toString() {
        return String.format("TributeImage{url=%s, width=%s, height=%s}", this.path, this.width, this.height);
    }
}
