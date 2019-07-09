
## GoBills - RELEASE

** v3.30 ** 
=========================
- GOJ-75826] the text “Back” should not be there in history screen
- [GOJ-81504] NEXT button should not be enabled for workflow `denomination_listing_with_no_pre_input` if user has not input ID and selected denomination
- [GOJ-81679] automatically load denomination when recent customer ID list only has single value

** v3.28 ** 
=========================
- Remote notification custom view

** v3.27 ** 
=========================
- Integrated Payment Widget for dynamic billers with remote config and segmentation
- Removed GoPay app bar from all screens

** v3.23 ** 
=========================
- "New" tag for category and biller
- for biller with workflow `denomination_listing_with_no_pre_input` NEXT button is made enabled only after user select denom
- fixed missing bahasa localization for vouchers
- how to redeem info should open in app web view while external link should open in browser

** v3.22 ** 
=========================
- BPJS: fixed bug, showing incorrect value for total bill month in inquiry result screen

** v3.19 ** 
=========================
- Changed of email endpoint for Go-Bills wherever used `gobills/v3/email` to `/bills-bff/v1/email`
- Implemented New Deeplink Implementation for all the billers
- Added Calendar widget for BPJS to Dynamic UI

** v3.18 ** 
=========================
- Added Denomination for Dynamic UI

--------------
** v3.17 ** 
=========================
- Cashback Voucher for Dynamic billers
- Remote config key:
-`feature_bills_vouchers` for dynamic billers


--------------
** v3.16 ** 
=========================
- Enabled Terms and Conditions section for Mobile Legends. (Branch for hotfix in 3.15 [ If possible ] => hotfix/mobileLegends)


--------------
** v3.15 ** `05 October, 2018`
=========================
- New biller, IndiHome, using Dynamic UI implementation

- Added remote config keys:
    - `feature_bills_bff_billers_endpoint_enabled` for switching between old and new API when fetching product list

--------------
** v3.14 ** `20 September, 2018`
=========================
- Changed T&C to `https://www.go-jek.com/id/go-bills/mobile/terms/` for all billers
- Made deeplink from banner response made optional

- Added remote config keys:
    - `feature_gobills_banner_3_14` For banner list

- Removed remote config keys:
    - `feature_gobills_banner`


** v3.13 ** `07 September, 2018`
=========================
- Introduce banner on Home Page
- Show confirm leave popup on right swipe mobile legends screen

- Added remote config keys:
    - `feature_gobills_banner` Contains json data for the banner (if empty, will not show banner view)


** v3.12 ** `20 August, 2018`
=========================
- Mobile Legends
- Biller disabled check using `AllBillers` API call behind remote config
- Added GoBillsBridging to depricate global `billsDelegate` variable
- some code cleanup

- Added remote config keys:
`feature_bills_mobile_legends` Enable the Mobile Legengs
`feature_bills_all_billers_api` Enable the AllBillers API call



# Go-Bills iOS
Has been live since v2.30

## Bills Module Types
Currently, we have 3 types (Government, Voucher Code & MultiPayment) and 4 modules (PLN, BPJS, Voucher Code & MultiPayment) for 6 Biller Categories (PLN, BPJS, Google Play Voucher Code, Multifinance, Insurance & Cable TV and Internet).

The reason, why we distinguish the category types is to make easy to manage and make more simple.

The difference are:
* Government type is category type which has mandatory rules that we need to follow it, so all billers that coming from Government become Government Type.
* Voucher Code type is category type for billers that will provide voucher code / token after purchase. Also has denominations only and without any ID as requirement.
* MultiPayment type is category type for pay bill that need ID as requirement.
* TopUp type is category type for purchase denomination that need ID & denomination as requirements.

Then currently,
* we have two government categories (PLN & BPJS)
* we have one voucher code categories (Google Play Voucher Code)
* we have three multipayment categories (Multifinance, Insurance & Cable TV and Internet)

* PLN category has 3 biller type : PLN Prepaid, PLN Postpaid and PLN Nontaglis
* MultiPayment has some billers that coming from BE as dynamic.

On the future, we will implement a lots of government, voucher code, multipayment and topup billers.

![](/GoBillsDocAssets/GoBills-ModuleType.png)


## Bills Module Relationship
Module Relationship in Bills is simple enough, we will see all categories in homescreen, then we has biller list screen for category which have more than one biller from BE. Currently only for MultiPayment category type.
![](/GoBillsDocAssets/GoBills-ModulesRelationship.png)


## Bills Services
Bills has 2 services, they are v2 and v3. We have new service (v3) to make one service as base for Pay products (Bills, Charge, Work & etc). Since v2.34 we adding v3 service under remote config. We are planning to remove v2 service code in v3.5.

Note. v2 only implemented for PLN, BPJS, Voucher Code and History.
![](/GoBillsDocAssets/GoBills-Services.png)


## Bills API Endpoints
Thes are the API Endpoints list that we used for Bills service, both v2 and v3 services.
![](/GoBillsDocAssets/GoBills-APIs.png)


## Bills Common Relationship
These are commons that we used on Bills, this will be updated because since v3.2 we're doing refactoring to make code clean and good.
![](/GoBillsDocAssets/GoBills-CommonsRelationship.png)


## Bills iOS Architecture
We uses VIPER Architecture as iOS Architecture Pattern.
So, every module has:
* Module class
* Assembly Class
* View Class
* Interactor Class
* Presenter Class
* Wireframe / Router Class

and has 2 base commons class:
* Bills Common Assembly class
* Bills Product Router class


## Bills Documents
These are documents for Bills
* Confluence Document: https://bit.ly/2GKG6Xa
* Deeplinking Document: https://bit.ly/2GoLsbi
* Analytic Document: https://bit.ly/2GKcMjM


Last updated: April 2, 2018 - by: Yefta Andrea
