## GoPay

--------------
** v3.31 ** `07 June, 2019`
=========================
**Ongoing:**
- KYC for thailand

- P2P theming
- Create Multiple Product Journeys (Unordered)

Remote config keys:
>  `xxx_kyc_xxxxxx_xxx`  KYC changes for thailand

--------------
** v3.30 ** `10 May, 2019`
=========================
**Ongoing:**
- Started work on P2P theming
- Create Multiple Product Journeys (Unordered)

**Fixes:**
- Nearby: Overlapped text for List of Promo in case of 5 or more promo and not able to go bac ` https://favro.com/organization/e6814c733bbceda252acf175/0dde3203c695aae65edb463d?card=GOJ-85663`
- Nearby: Onboarding Tool tips does not fades away if a deeplink is opened at the same time `https://favro.com/organization/e6814c733bbceda252acf175/0dde3203c695aae65edb463d?card=GOJ-40036`
- UTC time getting shown while selecting a promo for details `https://favro.com/organization/e6814c733bbceda252acf175/0dde3203c695aae65edb463d?card=GOJ-81473 ` 
- No section separator after journey component `https://favro.com/organization/e6814c733bbceda252acf175/0dde3203c695aae65edb463d?card=GOJ-81761`


--------------
** v3.29 ** `25 May, 2019`
=========================
- Promo animation on GoPay dashboard
- Update Customer withdrawal bank list
- Creating shuffle card for journey

**Fixes:**
- GP Transfer failed event is getting logged in case of the pin prompt in Pay through chat/ P2P
- In Parking, `Label` text & icon are displayed in loading state `https://favro.com/organization/e6814c733bbceda252acf175/0dde3203c695aae65edb463d?card=GOJ-79699`

Remote config keys:
>  `feature_pay_onboarding_promo_anim_count`  Conut for promo icon animation


--------------
** v3.28 ** `25 April, 2019`
=========================
- Added Request Money Chat Notification
- Send the ChanneliD in the Chat P2P flow
- Create Multiple Product Journeys (Only Ordered)
- Fixed phone number formatting issue in chat screen

- Support for ordered multi-product journey with `version - 2`


--------------
** v3.27 ** `11 April, 2019`
=========================
- GoPay Promos(Offers) on GoPay dashboard    
- Started work on Paylah integration 
- Payment Widget integration for Offline[Static and Dynamic QR]
- Added support to scan ASPI QR - static (QRIS) - call  `/explore` in case of plain data (instead of valid json)


Remote config keys:
>  `feature_gopay_promos`  key for enablement of Promo fetaure in GoPay-DashboardView
>  `feature_pay_aspi_qr` to enable scan ASPI QR feature
>  `journey_service_types`  Show available products journey in promos

Segmentation keys:
>  `feature_gopay_promos`  key for enablement of Promo fetaure in GoPay-DashboardView
>  `feature_pay_aspi_qr` to enable scan ASPI QR feature

Removed Segmentation keys:
>  `feature_active_sessions` was used for to toggle active session feature

**Fixes:**
- Numeric Keyboard is not hidden when user taps on TopUp Instructions
- 'Delete' icon on notes section doesn't work post submission of notes. Also, the green check disappears on clicking 'X' icon
- Timer Value to be used from remote config in case of merchant redirection after transaction success
- Fixed cashback getting truncated in receipt shared

--------------
** v3.26 ** `28 March, 2019`
=========================
- Show verified tag on Receiver's name in Chat and P2P
- Updated GOPAY transaction status screen - Phase 2

--------------
** v3.25 ** `14 March, 2019`
=========================
- Added deeplink upto instruction-tab.  
- Started work on customoji

** v3.24 ** `28 February, 2019`
=========================
- Added payment widget entry-point in gopay-settings behind config value

Remote config keys:
> `feature_pay_widget_in_setting`  key for enablement of paymet-widget-setting in GoPay-settings

** v3.23 ** `14 February, 2019`
=========================
- BCA Input Box Usability Improvement
- Onboarding for Journeys
- Removed in-app conditions to display chat messages regardless of remote-config values (https://gojek.slack.com/archives/C9HSY2RTR/p1549321019018500)
- Removed chat-extension initialisation check, now it will be initialised irrespective of remote config toggle 

- Journey Analytics CT events
- Lottie Animation for mission
- How to start section on new mission details

- Removed `EMVCo` support from the app `(v1/qr/explore)`
- Secure parking feature behind remote config

- Split Bill bugfixes
- fixed Recent contacts section gets misplaced when transfer through phone number deeplink is opened
- fixed Delay on gopay barcode button
- [GoPay Chat] caches view to improve scrolling performance

Remote config keys:
> `feature_secure_parking` key for secure parking.
    
Removed remote config Keys:
> `feature_pay_emvco` key feature EMVCo


** v3.22 ** `31 January, 2019`
=========================
- Split bill in group chat
- Mission

Remote config keys:
	 - `feature_pay_group_chat_request` for Split bill in group chat, reusing same key that was used for Send Money in Group Chat (1:1, 1:Many)
        - `feature_journey_flag_2` for enable feature mission, same key for segmentation

Fixes:
- Added Source as event property in Payment feedback event

** v3.21 ** `17 January, 2019`
=========================
- Changed BCA bank logo for card list.
- Added Withdrawal validation check for minimum amount 
- Added Bank Account name validation to letters and space and Dot as allowed characters.

- Remote config keys:
        - `feature_pay_withdraw_minimum_amount` used to get minimum ammount for withdraw 


Fix:
- Fixed localisation for `ADD BCA DEBIT CARD` string, it was not localised to Bahasa under settings page
- Fixed localisation for nearby promo ribbon text

** v3.20 ** `3 January, 2019`
=========================
- Changed analytics property to NewRedesign in `GP Pay by Code` event
- Updated the new occupation list for KYC
- Updated String tracker file with few exceptions. `Explicitly added requestMoney strings`


** v3.19 ** `20 December, 2018`
=========================
- Added test module entry points for pay widget for integration only
- Changed text for key `go_pay_dd_other_methods` for TopUp flow; `Other methods` to `Instruction`
- Added deep link redirection for experiment framework, handled via push notification redirection for same


- Remote config keys:
        - `feature_pay_experiment_framework_deeplnik` used for experiment framwork deeplink 

- Removed Segmentation Keys:
    - `feature_pay_payment_success_feedback` used for payment feedback feature 

Fixes:
- Fixed balance visibility on dashboardView while offline
- Fixed truncation of default text in the recent section on Small screen devices for Pay redesign flow


** v3.18 ** `05 December, 2018`
=========================
- Fixed crash due to force-unwrap in NearBy
### https://fabric.io/user-inspired/ios/apps/com.go-jek.ios/issues/5bc0577ff8b88c29638b77a3?time=last-seven-days
- Changed KYC onboarding images for DL and KTP
- Send Money in Group Chat (1:1)
- Remove Remote config related to PIN challenge
- Redesign Pay Screen (Without recent merchants)

Remote config keys:
    - `feature_pay_bottom_home_screen` for payment redesign feature without recent merchant
	 - `feature_pay_group_chat_request` for Send Money in Group Chat (1:1)
		

Segmentation keys:
    - `feature_pay_bottom_home_screen` for payment redesign feature without recent merchant

NearBy:
- Deep Link for Nearby Tags

Configurational changes:
- Removed DirectDebit feature segmentation `feature_direct_debit_v3_13`
- Removed Topup instrunction feature segmentation `feature_pay_topup_instructions`

External:
Removed PIN challenge while editing phoneNumber
GoOAuth: https://source.golabs.io/mobile/ios-ca-auth/merge_requests/442
CoreAuth: https://source.golabs.io/mobile/ios-ca-core-auth/merge_requests/85

** v3.17 ** `16 November, 2018`
=========================
- KYC Frame Readjustment behind remote config
- Payment feedback after every transactions
- Nearby search bar hint text from remote config value


- Remote config keys:
        - `feature_pay_payment_success_feedback` for payment feedback feature
        - `nearby_search_text` for nearby search hint text
        - `feature_pay_kyc_frame_enhancement` for KYC frame

- Segmentation keys:
        - `feature_pay_payment_success_feedback` for payment feedback feature
        
- Removed Segmentation Keys:
        - `feature_pay_scan_my_qr` used for 
    
    **Fixes:**
    - Fingureprint should required again after on Scan My QR button.
    - Fixed timer issue on Scan My QR
        
    **Nearby : -**
    - Change text on Nearby search bar behind remote config
    
    - Remote config keys:
        - `nearby_search_text` for search bar
    

** v3.16 ** `24 October, 2018`
=========================
- Enable Nearby filter to everyone

- Removed remote config keys:
        - `feature_nearby_filter` Was used to enable NearBy filters

** v3.15 ** `04 October, 2018`
=========================
- Added merchant redirection feature for external apps

- Removed remote config keys:
        - `feature_pay_merchant_redirect` Enable the merchant redirection feature
        - `feature_pay_merchant_redirect_timeout` Get the redirection timeout duration default is 5sec app side

- Added segmentation config keys:
        - `feature_pay_topup_instructions` Enable the biometric feature for PIN

- Nearby Vouchers Implementation with UI and model update
        - `feature_nearby_gopoints_voucher` added for nearby vouchers

- Top Up Instructions UI change and implementation with remote config and segmentation



** v3.14 ** `20 September, 2018`
=========================
- Integrate Fingerprint ID as an additional authentication mechanism

- Added segmentation config keys:
        - `feature_fingerprint_authentication` Enable the biometric feature for PIN
        - `feature_explore_v3_14` Enable feature explore api service for static qr codes

- Removed remote config keys:
        - `feature_fingerprint_authentication` Enable the biometric feature for PIN

Fixes/Improvements :
- Removed hard-coded check to bypass prod environment for chat
- Changed the Pay button title to Pay Now for Chat-request card.
- Changed cash-flow icons for chat cards
- Changed date and text formate for ActiveSession
- Changed title of card load failed button for direct debit

**Nearby : -**
- Added deepling with searched string for merchant list
- Started work on suggested nearby vouchers

PaySDK:
- Used device's biometric feature for GoPay PIN for transactions


** v3.13 ** `05 September, 2018`
=========================
- Completed one to one Chat flow for transfer and request with Analytics
- Show education cues in the merged Scan QR and P2P transfer screen
- Show all active sessions for a user
- Added Explore-Api for Merchant Static QR codes only
- Rollout transfer new design to 100% users. So removed required checks to enable new design
- Fixed transfer tile name to `Pay`
- Added Bills and Pulsa entry point in GoPay more also changed sequence of icons

- Removed bill split code and required files and localisations
- Removed old transfer flow code (Partially)

- Added remote config keys:
       - `feature_direct_debit_v3_13` Enable the BCA feature
    
- Added segmentation config keys:
       - `feature_direct_debit_v3_13` Enable the BCA feature

- Removed remote config keys:
        - `pay_split_bill_enabled` used for BillSplit
        - `gopay_split_bill_share_base_url` was used for get share url
        - `pay_transfer_tile_name`  was used for get tile name
        - `pay_transfer_design_v3_10` was used to enable redesign feature

- Removed segmentation keys:
        - `pay_transfer_tile_name_send` was used to categories redesign feature for Send title
        - `pay_transfer_redesign` was used to categories redesign feature

PaySDK:
- Ignored Wallet-lock value from `profile` api call in GoPaySDK, reading respective value from `profile/detail` api call only

Other Participants:
- Added L1/L2 `device rate limit` implementation for auth login api call (AuthEngine repo)

** v3.12 ** `20 August, 2018`
=========================
- Started working on Chat flow for transfer and request
- Added remote config keys:
        `feature_pay_chat_transfer` Enable the Transfer widget
        `feature_pay_chat_request` Enable the Request widget
        `feature_paylater_312` updated segment and remote config for paylater
        
- Transfer-via-chat completed, Request-via-chat is pending.
- Change view for notification from alert to view from top when app is active
- Show education cues in the merged Scan QR and P2P transfer screen
- Showing the error message on invalid deeplink

Fixes :
- Fixed warnings introduced but to GoCommon deprecation
- Fixed ScanQR is being stuck when there is a space in `receiverId` of MerchantQR
- Fixed deeplink redirections for kartuku



** v3.11 ** `03 August, 2018`
=========================
- Add support of `Spotlight` for keyword specific redirections, descriptions, and icons
- Remove Mappable from models
- Add paste icon if user has valid phone number (05-20) on his clipboard.
- Rewrite GoPay dashboard view
- Fix: Formatting of phoneNumber when phoneNumber characters are less than the total count of split array (Ex: 8902)
- Added segmentation keys:
    - `feature_nearby_filter` For Nearby fetaure 
- Removed remote config keys:
    - `feature_nearby_v3_8` For Nearby fetaure 
- Removed segmentation keys:
    - `feature_nearby` For Nearby fetaure 
    
**Nearby : -**
- Add filter option in nearby home screen behind segmentation `feature_nearby_filter`
- Fix: nearby list screen being stuck when merchant images are large
- Rollout Nearby to 100% users by removing `feature_nearby_v3_8` remoteConfig and `feature_nearby` segmentation tag
- Implement separate method to get promotion icons based on promo type for nearby


** v3.10 ** `16 July, 2018`
=========================
- Changed firebase config to `pay_transfer_design_v3_10` for pay-re-design as we added Analytics  
- Added remote config keys:
        - `feature_nearby_gopay_banner` For Nearby fetaure 
        - `pay_transfer_design_v3_10` For payRedesign with events
        - `feature_nearby_banner_values` for banner on nearby home
        - `pay_v3_payment_request` for v2/v3 API request
        - `feature_nearby_scanqr` For opening Neabry from ScanQR

- Added Segmentation  keys:
        - `pay_transfer_tile_name_send` For title name A/B testing

- Add Festive notes at first place which will be toggle from config.
- Analytics for Pay Redesign.
- Added offline-voucher support in old and new designs (v2/v3 api toggle behind remote cponfig `pay_v3_payment_request`) 
- Add common event properties for every event.
- Pass `launcher.remoteConfigFetcher` to GoPayRemoteConfig instead of bridging itself.
- Remove getRemoteConfigValues from bridging.
- Add no contact found state in contact-list.

**Nearby : -**
    - Added NearBy tile in GoPay banner behind remote config `feature_nearby_gopay_banner` and degraded the Receive tile to GoPayHome(bottomSheet)
    - Add feedback section in merchant profile view.
    - Enable deep link for Nearby by scanning a QR code.
    - Add banner on Nearby home screen.
    - **Fix**: Mapping of dayRawValue to WeekDay.
    
Fixes :
- Highlight searched value in `Number` in contact list.
- Send a note for (name) should be changed to Add a note (Strings)
- Fix issue with custom note selection after clicking `delete` button.
- Fix selection of note tags while scrolling now its unselect.
- Title should be Payable Amount instead of Billing Amount.
- KYC Onboarding: Rename Transfer Title and Description (Strings)
- Handle app update error for unknown scan activities.
- Solved blur effect from scanQR screen for 4s device for being slow.
- Change payable amount as per discount applied once respective discount/promo selected through list.
- Change Contact section list header with proper title (If search results ==> Searched Contacts; Else ==> All Contacts)
- Used `tost` for success screen once transaction Id copied on clipboard
- Removed colon(:) mark from TransactionId cell from success screen, this will create bug in older screen.
- Fixed title of `Terms and Condition`, should be in capitalised string
- Updated `Bill Already Paid` errorImage, title and description


** v3.9 ** `08 June, 2018`
=========================
- Notify me for long running BCA Top Up transactions behind remoteConfig (default timeout - `200 sec`)
- Changed Transfer Redesign segmentation key to `pay_transfer_new_design` and removed respective older key
- Added remote config keys:
        - `pay_transfer_new_design` For feature enablement
        - `pay_bca_notify_later_timeout` For BCA timeout
        
- Terms and condition in card for redesigns only
- Heighlight searched text for name in contact list (Pending for numbers)
- Selection for promos on review payment screen for dynamic QR
- Add contact to address book from transfer success screen.
- Sharing option on transfer success screen.
- Save contact after transfer success using phone number (P2P only)
- Added functionality to copy order/transaction ID from transfer success screen
- Added deeplink support for transfer redesign
- NearBy new design for merchant details screen

Fixes:
    - Update payment notes layout
    - Update `Amount Enter` screen layout for smaller devices(4s)
    - Added location accuracy warning in edit location view for NearBy


** v3.8 ** `24 May, 2018`
=========================
- New Transfer Designs (`without Pay merchant via Phone number`)
- Merged tile on home screen (Transfer & Scan) ==> (Pay/Send)
- Custom keyboard with Calculator
- A/B testing of the merged pay/scan label
- Share QR-code and read QR-code from image-gallery
- Added remote config keys:
        - `pay_transfer_redesign` For feature enablement
        - `pay_transfer_tile_name` For A/B testing for tile name
        - `pay_qr_feature_list`  For to get supported feature set through ScanQr

- Added Segmentation  keys:
        - `pay_transfer_redesign` For controlled rollout

- Fixed error cases for Voucher screens
- BCA DirectDebit: Add environment variable to support both production and staging frameworks

-  `Note`:
    - Don't consider such contacts `if contact has more than 10` phone numbers (Discussed with Manu)

- `Nearby`:
    - Add shimmering effect
    - send `sort_by_loc` parameter for fetching nearby list
    - Update ServiceID of nearby to 39
    - Add GNB onboarding event
    - Sort operational hours 
    - Show `Unserviceable` when merchant's `force_close` is true and don't show operational hours when `active` is false
    - Add `GNB onboarding` event
    - Update logic to show operational hours (Remove operational hours sections if operational hours is empty in the response)
    

** v3.7 ** `11 May, 2018`
=========================
- Add the `PinSet` event property in Edit phone number events (GoJek main repo)
- Nearby (*Alpha release*) with remoteConfig and segmentation
- Change pending feature list UI in GoPay Home for PIN and KYC
- Put red coloured badge on GoPay more icon in GoPay dashBoard View(GoJek Home)
- Changed people property key for Balance to `user_gopay_balance`
- Added PayLater tile on GoPay Home for GoFinance product (behind segmentation key - `feature_pay_later`)
- Added remote config keys:  
      - `feture_nearby`
- Added segmentation keys: 
      - `feature_nearby`
      - `feature_pay_later`

- Fixes:
      - Edit wording in merchant verification : Eng : `verified` , IND :`terverikasi`

Incomplete:
- None

** v3.6 ** `26 Apr, 2018`
=========================
- Added BCA analytics events
- Changed BCA segmentation key to `pay_feature_direct_debit_v3.6` and removed older key
- Removed older GoPay-Home
- Removed error screens while Profile call from more button screens and keep while come through deeplinks
- Removed OTP screen from Asphalt(Common UI repo) and added in GoPay itself
- Removed universal app deep link as we are following EMVCO
- Added deep-link redirection for weburls to Safari for Push Notification
- Removed following firebase remote config flags:
        `pay_home_redesign`
        `pay_kyc_enhancement`
        `pay_feature_direct_debit`
- Add Nearby code without entry point
- Fixes:
        `transferqr` deplink with `qr_id` param was not working

Fixes:
- Refresh Bank details not reflected in setting page once they added (first time experience only)
- Changed logic for amount textfield and apply max length to 15 characters including symbols and separators
- Change all `event parameters` text case to `Pascal Case` as we are following this as a standard (DD, KYC, Common)
- Read `calleeSource` from deeplink params and used for first analytic events (e.g TopUp Selected,..) 

Incomplete:
- NearBy feature disabled at code level
- Treansfer screen redesign
- Notify me for long running BCA Top Up transactions

** v3.5 ** `12 Apr, 2018`
=========================
-  KYC analytic events
- Home redesign fixes specially deeplink issues


** v3.4 ** `02 Apr, 2018`
=========================
- Home Redesign behind toggle( `pay_home_redesign` ):
    - `Constraints:` Added 60 secs for to invalid cached profile data and hit profile call again, still then `More` tile will use cached values to redirect further
    - `Deeplink:` Added additional loader(screen) to fetch latest profile data everytime.
    - `Deeplink:` Added error card on gojek-home if profile call failed
- Added wallet blocked/locked card view for newer designs
- Changed support redirection to GoPay nanorep rather than root help screen
- Added accessibility identifiers for BCA/KYC flows
- Removed approuter dependancies completely(Continued from v3.3)
- Fixed duplication in city list used in KYC flow

** v3.3 ** `---`
=========================
- Add segmentation service for BCA DirectDebit
- Edit card name
- KYC compliance (behind remote config - `pay_kyc_enhancement`)
- Rp 0.0 should be Rp0
- Burst animation on success screen
- Removed AppRouter dependency in AppWebView, KYC, TopUp, P2P, ScanQR, Merchant, Receive, Transaction History, Redeem Voucher modules
- KYC events removed
- BCA events removed

** v3.2 ** `---`
=========================
- Add BCA direct debit feature along with remote flag
- Added support for EMVCo, behind with remote config (off)
- Update KYC assets with compressed images and (accepted and rejected) according to new rules
- Update KYC ID and selfie instructions
- Make changes according to PaySDK to track events in delegate instead of passing analyser
- Delete repeated assets and use assets with template rendering for common ones
- Remove mix panel related stuff (CleverTap migration)

Bug Fixes:
- ScanQRCodeView: Flash button color not set to white after scanning of QR code is finished
- ScanQRCodeView: Memory leak due to strong capturing in animation blocks
- TransactionDetails (TransferSuccessScreen): Constraints update


** v3.1 ** `15 Feb, 2018`
=========================
- Removed Old KYC flow
- Add InAppNotification view instead of alert for displaying KYC document upload status
- Remove special characters in Event names
  - Replace - with _
  - Use GOJEK instead of Go-Jek
  - Use GOPAY instead of Go-Pay
  - Replace & with n
- Bug Fixes:
  - Bank account to withdraw not changing if user chooses not to set the selected as default account (https://go-jek.atlassian.net/browse/INT-805)
  - KYC Onboarding view not dismissing when app opened through deep link (https://go-jek.atlassian.net/browse/INT-832)
  - Analytic source passed incorrectly and differently to different flows (https://go-jek.atlassian.net/browse/INT-830)
  - KYC Upload status notification getting triggered with delay
  - Shadow effect in KYC Instruction views
  - Update constraints in UserBlockView so that the content is centre aligned vertically

** v3.0 ** `24 Jan, 2018`
=========================
- KYC Redesign events
- Preview captured photos in KYC confirmation step
- Show camera permission card before displaying system alert
- KYC fixes

** v2.34 ** `8 Jan, 2018`
=========================
- KYC Redesign with remote config
- Bank search view refactor
- Set PIN reminder view on GoPay home.
- New remote config constants for all remote config strings.
- Check for contacts permission on recent contact.
- Name masking and address book name for P2P and Recent Contact.
- Updated common ErrorHandler and passing httpStatusCode to error object.
- Removed KYC local notification.
- Updated localisation strings from tracker file.

=========================

** v2.33 ** `15 Dec, 2017`
=========================
- Display and send discounts for kartuku (dynamic QR)
- Add SetPin deep link
- Support for universal link when user scans QR in 3rd party apps
- Support for new QR Code format (decode token by base64 to get the json)
- Add DashboardViews for new Gojek home redesign
- Make Navigation bars based on the theme passed by launchpad
- Fix: Inprocess debit transactions were displayed in green
- Remove remoteConfig for displaying change pin in settings 
- New UI changes for Success screen and cleanup
- Added keys for localisation text in through out the framework
- Split bill share text changes
- Send deeplink parameters for mixpanel events in transfer flow
- Remote Config check for KYC local notification
- Removed MAX and MIN version for scan QR
- Change default spilt members from 1 to 2 for BillSplit
- Add event for merchant transfer retry
- Add KYC check for BillSplit

=========================

** v2.32 ** `22 Nov, 2017`
=========================
- Split Bill
- Bug fixes

=========================

** v2.29 ** `21 Sep, 2017`
================================
> Changes:
- Localization Changes.
- Added Navigation Bar on Scan QR.
- Changed 'Set Now' to 'Complete Now' in Setting screen.
- Using cachedValue from paySDk in case of API fetch failure.
- Added a new entry in qr_scan_config.json for Go-Charge device detection.
- Removed home notification observer.
- Checking remoteConfig before presenting pin onboarding.
- Initialise payNetworkService by passing appROuter.
- Withdraw Refactoring.

> Fixes:
- Transfer button disable for blocked account.
- String mismatch on Setting screen.
- Resolved the continuous loading view on transfer.
- Handled the error case for adding same bank account.
- Deeplink: Screens are pushed multiple times.
- Loading indicator was not shown when HomeVIew is loaded.
- Resolved the Deep linking by making the UI changes in the main thread in Home View.

=======================

** v2.28 ** `24 Aug, 2017`
==========================
> Features:
- If GoPay balance is less than 10K then show TopUp and Receive on GoJek home
- Removed Resend OTP button click limit
- Added placeholder for Notes section on P2P view
- Added Notes section with placeholder on Scan QR
- On scan QR Show keyboard for for amount field
- On P2P view show keyboard for number field
- If user KYC status changes, will show the notification and redirect user accordingly
- Showing upload status from 0% while KYC starts uploading and disable cancel button on upload finish

> Fixes:
- After successful upload user remains on complete your id page on click of OK
- Error message was tracked in KYC failed event when upload of image to AWS server fails
- While QR scan noice on silent mode
- Variations in ios and android

===========================

** v2.27 ** `4 Aug, 2017`
==========================
> Features:
- Unit test for GoPay
- Added GoPay SDK

> Fixes:
- Disable submit button once transaction started (GPY-1231)
- In P2P, Changed the keyboard type to Number pad of contact number textfield.
- In P2P, Contact Number will not overlap with contact button.
- Value for "Number Of Bank Accounts" getting logged as 1 everytime when the bank is added from withdraw. (GPY-1268)
- Balance not getting updated after withdraw on the Withdrawal Page. (1267)

===========================

** v2.25 ** `13 July, 2017`
=====================
```
Develop Pod Version: `2.2.25.61`
```
=====================
> Features:
- Kartaku payment via merchant payment
- Added Flash light for Scan-Qr with analytics event
- Added scan animation, sound and vibration
- Updated all mixpanel events
- KYC Success/Fail analytics Event
- Added Error Tracking event for image failure only

> Fixes:
- Top Up link is removed from Go-Pay Voucher section
- Mixpanel changed source as "Deep Link"
- Opening settings via deeplink reports 2 events which is changed to 1
- Now customer can do P2P transactions on approval of KYC without killing the app
- Corrected the Error message when QR code is wrong
- Merchant transfer QR code enters an infinite loop and opens many deeplinks when QR is scanned, is fixed now.
- Added Mipanel event for Transaction history via deeplink
- Amount field in the Merchant Transfer Page is uneditable if the amount comes from QR
- Added deeplink for receive
- Added deeplink for withdraw
- Used correct localization for "NOTES (MAX 120 CHAR)"
- Fixed KYC image upload state issues
- Improve KYC image upload progress percentage issue

