# Learning Missions App - Tech Quest
## Descripción

REST API that allows teachers train students through learning missions and assigned skills.

# Project Setup

## Environment variables

1. Copy the [`.env.example`](./src/main/resources/.env.example) file of the `resources/` folder and create the **`.env` file**  in the same folder (`resources/`) **replacing with real variables**.

2. The `JWT_SECRET_KEY` must be an HMAC hash string of 256 bits; otherwise, the token generation will throw an error. **Use [this website](https://www.devglan.com/online-tools/hmac-sha256-online?ref=blog.tericcabrel.com) to generate one**.

    > [!TIP]
    > Use whichever text for the *"Text to Compute Hash"* and *"Secret Key"* fields in the website.

