# About Twitter4j-ads

Twitter4j-ads is a stable and well tested Java SDK for Twitter's Ads API, originally developed and then open sourced by one of the top social media companies building upon the Ads API (Sprinklr). 

Learn more about obtaining Ads API access by visiting: https://dev.twitter.com/ads/overview

### Getting started

1. Ensure that Gradle is installed and fork the Twitter4j-ads repo.
2. Use the `build.gradle` file to create a project for Twitter4j-ads.
3. Prepare the Consumer Key/Secret and Acess Token for your Ads API test application into appropriate place (see Authentication section for more information).
4. Build project and test with test examples or a new main function.

### SDK Structure and Design

The Twitter4j-ads Java SDK is built on top of design of Twitter4j to allow for easy integration with both Ads API and Organic (REST) API. Response objects are returned as iterable collections and SDK handles the work of paging with cursor for endpoints which support cursors.

### Gradle or Maven

We recommend using Gradle or Maven to build and manage your project using Twitter4j-ads. The included `build.gradle` file includes dependency information for quickly getting up and running.

### Dependencies

- JDK 1.7
- com.google.guava
- com.google.http-client
- com.google.api-client
- com.google.code.gson
- com.google.common.base.Optional
- joda-time
- commons-collections
- org.apache.commons
- junit

### Authentication

Twitter4j supports generally three methods of authentication: environment variables, configuration file, and via code functions. Configuration authentication through code is highly recommended to be able to store the access tokens in secure storage as well as scale the number of authentication tokens being used.

##### Consumer Key/Secret

Storing the consumer key and secret is how you authenticate your Ads API-approved App ID to access Twitter Ads API. Commonly this is stored in encrypted format in a place accessible by servers. Your Consumer Key/Secret for your Twitter Ads API application will come from http://apps.twitter.com.

##### Access Tokens

Access tokens are OAuth 1.0A generated tokens to allow access on behalf of a user (advertiser) that has given permission to run campaigns on their behalf.

Your implementation code will need to intelligently allow switching between different access tokens in order to provide functionality for more than one advertiser.

Please reference this Twitter Ads API documentation for more help in generating access tokens: https://dev.twitter.com/ads/overview/obtaining-ads-account-access

### Contributors

* Abhay Bansal (Sprinklr)
* Abhishek Anand 
* Akash Maurya (Sprinklr)
* John Babich (Twitter)
* Nihit Purwar (Sprinklr)
* Prashant Dubey (Sprinklr)
* Vinit Kataria (Sprinklr)
* Niket Khandelwal (Sprinklr)

## Credits
Yusuke Yamamoto - yusuke at mac.com using https://github.com/yusuke/twitter4j with minor modifications

### LICENSE

The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
