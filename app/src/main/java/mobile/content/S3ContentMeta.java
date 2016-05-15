package mobile.content;
//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.7
//

import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.File;

public class S3ContentMeta implements ContentItem {
    private final ObjectMetadata objectMetadata;
    final String objectKey;
    private ContentState contentState;

    public S3ContentMeta(final String objectKey,
                         final ObjectMetadata objectMetadata,
                         final ContentState contentState) {
        this.objectKey = objectKey;
        this.objectMetadata = objectMetadata;
        this.contentState = contentState;
    }

    /** {@inheritDoc} */
    @Override
    public long getLastModifiedTime() {
        return objectMetadata.getLastModified().getTime();
    }

    /** {@inheritDoc} */
    @Override
    public String getFilePath() {
        return objectKey;
    }

    /** {@inheritDoc} */
    @Override
    public long getSize() {
        return objectMetadata.getContentLength();
    }

    /** {@inheritDoc} */
    @Override
    public ContentState getContentState() {
        return contentState;
    }

    /** {@inheritDoc} */
    @Override
    public void setContentState(final ContentState contentState) {
        this.contentState = contentState;
    }

    /**
     * @return null because this object only contains metadata. In order to
     * get the file from local cache, you must first tell the ContentManager to
     * download the file contents with a getContent call.
     */
    @Override
    public File getFile() {
        return null;
    }

    /**
     * @return the S3 object summary representing this content.
     */
    public ObjectMetadata getObjectMetadata() {
        return objectMetadata;
    }
}
