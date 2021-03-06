/*
 * Copyright 2010-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.example.iam;
import software.amazon.awssdk.services.iam.model.DeleteAccountAliasRequest;
import software.amazon.awssdk.services.iam.model.DeleteAccountAliasResponse;

import software.amazon.awssdk.core.regions.Region;
import software.amazon.awssdk.services.iam.IAMClient;

/**
 * Deletes an alias from an AWS account
 */
public class DeleteAccountAlias {
    public static void main(String[] args) {

        final String USAGE =
            "To run this example, supply an account alias\n" +
            "Ex: DeleteAccountAlias <account-alias>\n";

        if (args.length != 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String alias = args[0];

        Region region = Region.AWS_GLOBAL;
        IAMClient iam = IAMClient.builder().region(region).build();
        
        DeleteAccountAliasRequest request = DeleteAccountAliasRequest.builder()
            .accountAlias(alias).build();

        DeleteAccountAliasResponse response = iam.deleteAccountAlias(request);

        System.out.println("Successfully deleted account alias " + alias);
    }
}
