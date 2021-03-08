# Project 3 - *Instagram Clone*

**Instagram Clone** is a photo sharing app similar to Instagram but using Parse as its backend.

Time spent: **8** hours spent in total

## User Stories

The following **required** functionality is completed:

- [x] User can view the last 20 posts submitted to "Instagram".
- [x] The user should switch between different tabs - viewing all posts (feed view), compose (capture photos form camera) and profile tabs (posts made) using fragments and a Bottom Navigation View. (2 points)
- [ ] User can pull to refresh the last 20 posts submitted to "Instagram".

The following **optional** features are implemented:

- [x] User sees app icon in home screen and styled bottom navigation view
- [x] Style the feed to look like the real Instagram feed.
- [ ] User can load more posts once he or she reaches the bottom of the feed using infinite scrolling.
- [x] Show the:
    - [x] username each post
    - [ ] creation time for each post  
- [ ] User can tap a post to view post details, including timestamp and caption.
- [ ] User Profiles
      - [ ] Allow the logged in user to add a profile photo
      - [ ] Display the profile photo with each post
      - [ ] Tapping on a post's username or profile photo goes to that user's profile page and shows a grid view of the user's posts 
- [ ] User can comment on a post and see all comments for each post in the post details screen.
- [ ] User can like a post and see number of likes for each post in the post details screen.

The following **additional** features are implemented:

- [x] User profile image included and referenced from database, however cannot update in App yet

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/H9lAssi.gif' title='Video Walkthrough' width='300' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

The biggest challenge I faced during this project was not forgetting a ParseUser would not be logged in if the App was executed in a new virtual device. When I ran the app on a new virtual device, I was not prompted with the login screen and because of that I was unable to execute bits of code such as 'ParseUser.getCurrentUser()'. This was very frustrating as the application seemed to still be able to access the Back4App backend, however getting the current user kept resulting in null. It was not until I tinkered with the LoginActivity and the AndroidManifest that I realized the current user was not "logged in" and was allowed to bypass that.

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## License

    Copyright [2021] [David Serrano]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
