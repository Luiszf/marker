#!/home/luis/.nix-profile/bin/zsh

PORT=8080
BASE_URL="127.0.0.1:${PORT}/api/v1"
TOKEN=$(curl -s -X POST -H 'Accept: application/json' -H 'Content-Type: application/json' --data '@json/auth.json' ${BASE_URL}/auth/login | jq -r '.token')

curl -v -H "Authorization: Bearer ${TOKEN}" --data '@json/small_product.json' -H "Content-Type: application/json" ${BASE_URL}/product
curl -v -H "Authorization: Bearer ${TOKEN}" --data '@json/medium_product.json' -H "Content-Type: application/json" ${BASE_URL}/product
curl -v -H "Authorization: Bearer ${TOKEN}" --data '@json/large_product.json' -H "Content-Type: application/json" ${BASE_URL}/product
