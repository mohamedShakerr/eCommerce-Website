package org.iti.utils;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

public class S3ClientProvider {


    private static S3ClientProvider s3ClientProvider = null;

    private  S3Client s3Client;

    private S3ClientProvider(){}

    public void initializeClient(String id, String key){
        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(id, key);
        Region region = Region.EU_CENTRAL_1;
        s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
                .region(region)
                .build();
        System.out.println("Client Init");
    }

    public static S3ClientProvider getInstance() {
        if (s3ClientProvider == null){
            synchronized (S3ClientProvider.class) {
                if (s3ClientProvider == null) {
                    s3ClientProvider = new S3ClientProvider();
                }
            }
        }
        return  s3ClientProvider;
    }

    public S3Client getS3Client(){
        return  s3Client;
    }

}
