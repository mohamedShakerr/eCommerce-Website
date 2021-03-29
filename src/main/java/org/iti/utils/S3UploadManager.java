package org.iti.utils;


import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

public class S3UploadManager {

    public static final String BUCKET_NAME = "ecommerece-iti";


    public  S3UploadManager(){}

    //Will Upload Byte array and return it's URL
    public String uploadImage(byte[] byteArr){
        S3ClientProvider s3ClientProvider =S3ClientProvider.getInstance();
        S3Client s3Client = s3ClientProvider.getS3Client();

        String fileName = UUIDProvider.getUUID();

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .acl(ObjectCannedACL.PUBLIC_READ)
                .key(fileName)
                .build();

        s3Client.putObject(putObjectRequest,
                RequestBody.fromByteBuffer( ByteBuffer.wrap(byteArr) ) );

        return s3Client.utilities().getUrl(builder -> builder.
                bucket(BUCKET_NAME)
                .key(fileName))
                .toExternalForm();
    }


    public void deleteImage(String imageUrl){
        URI uri = null;
        try {
            uri = new URI(imageUrl);
            //ASSUMING WE UPLOAD DIRECTLY  TO BUCKET
            String fileName = uri.getPath().substring(1);

            S3ClientProvider s3ClientProvider =S3ClientProvider.getInstance();
            S3Client s3Client = s3ClientProvider.getS3Client();

            DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
                    .builder()
                    .bucket("BUCKET_NAME")
                    .key(fileName)
                    .build();

            s3Client.deleteObject(deleteObjectRequest);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }


}
