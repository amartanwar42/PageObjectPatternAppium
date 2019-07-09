# How to add a new Litmus Experiment

## If you want to add a new experiment here are two cases:

### Add a new experiment to a list of existing experiments (say `Chat`):

- Add the new experiment name as one of the case to `ChatExperiments` enum:=>

``` swift
    public enum ChatExperiments: String {
        case rollout = "chat_rollout"
    }
```    

- Fix the compilation errors  (due to additional case added above) with appropriate  logical statements


### Add an experiment for a product for the first time (say `Chat`):

- Create a new file `ChatExperiments.swift`  under `LitmusKit -> Experiments` folder
- Create a new `String` Enum as follows =>

``` swift
    public enum ChatExperiments: String {
```   

- Add an extension to `ChatExperiments` to support `Experiment` protocol.
- If you have any logic which determines if an experiment is enabled or not based on Experiment prosperities, you would need to override `isEnabled(….)` method. Refer ChatExperiments.swift for a sample implementation.

