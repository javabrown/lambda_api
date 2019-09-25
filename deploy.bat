rem create bucket
aws s3 mb s3://rk-lambda-api

rem copy the jar file to the S3 bucket
aws cloudformation package --template-file sam.yaml --output-template-file target/output-sam.yaml --s3-bucket rk-lambda-api

rem deploy a cloud-formation stack from the SAM template
aws cloudformation deploy --template-file target/output-sam.yaml --stack-name rk-lambda-api --capabilities CAPABILITY_IAM

rem describe the stack, which will display the URL of the API in the outputs.
aws cloudformation describe-stacks --stack-name rk-lambda-api