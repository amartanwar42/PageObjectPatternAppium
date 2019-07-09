# How does help work?

Help is contructed initially as follows:
`RootNavigationController` (`UINavigationController`)
- `HelpViewController`

## Loading

`HelpViewController` is capable of loading up nanorep if it is enabled, else it will display the old help section (simple table view with entries of products).


`NanorepWidgetController` extends `NRWidgetController` and is responsible for displaying help content from nanorep. It also has hooks that allow it to create Zendesk tickets from the app. There is a complicated mapping that takes place between nanorep form data to zendesk form data.

We use the default controllers and ui components that nanorep provides by default, and it is not customized.


## Theming

Both help controllers support theming by declaring `Themeable` conformance.

In the nanorep UI, the view that is presented for capturing form details (`NRChannelingView`) does not conform to `Themeable`. We override the `present()` method and hack into the view hierarchy to set its theme. Currently, this is the only way since NRChannelingView by default does not use the configuration settings specified in the `fetchConfiguration()` call. (bug)

## Language changes

When language change happens, the current view controller will reload itself. `NanorepWidgetController` will kick itself out, and push a new `HelpViewController`.

This will inturn trigger loading help with the new language.

