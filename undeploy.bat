rem delete stack
aws cloudformation delete-stack --stack-name rk-lambda-api

rem better handling needed.
aws s3 rb s3://rk-lambda-api --force