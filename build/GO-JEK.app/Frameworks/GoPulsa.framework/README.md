## GoPulsa - Notes

** v3.28 ** `25 April, 2019`
=========================
- Removed older voucher implementation which was not used as bff-api usage rolled out 100%

Removed config keys:
>   `feature_pulsa_voucher_enhancement_enabled` pulsa promos with `bff` service
>   `feature_gopulsa_vouchers_autoapply` points voucher with point service sdk
>   `vouchers_sdk_timeout_value_pulsa` to provide timeout for point-service sdk

** v3.27 ** `12 April, 2019`
=========================
- Integrated payment widget
- Enabled the voucher enhancement feature, enabled through code (Needs to clean the code)
 
- Remote config keys:
> `feature_pay_pw_pulsa` used to enable payment widget integration

** v3.23 ** `14 February, 2019`
=========================
Fixes:
- pulsa cashback voucher missing localization for bahasa
- available voucher text is not vertically centered

** v3.21 ** `17 January, 2019`
=========================
- Added Pulsa cashback voucher

- Remote config keys:
> `feature_pulsa_voucher_enhancement_enabled` used for pulsa cashback vouchers 

Fixes:
- Added centralised remote config class to read values
- Replace existing remote config value to newer structure 
- Added Currency handler as centralised and used throughout the app
