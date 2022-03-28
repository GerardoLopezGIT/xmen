# xmen
Esta api esta desplega en un EC2 de aws.

Operacion /mutant/

Se puede hacer  uso de ella con el siguiente curl:

curl --location --request POST 'http://xmen-env.eba-p3vxvgwp.us-west-1.elasticbeanstalk.com/mutant/' \
--header 'Content-Type: application/json' \
--data-raw '{
"dna": ["FTECDA","CAGEGC","TTATGT","AGAAGG","CCCCTA","DCADTD"]}'


Operación /stats/

Se puede hacer uso de ella con el siguiente curl:

curl --location --request GET 'http://xmen-env.eba-p3vxvgwp.us-west-1.elasticbeanstalk.com/stats/'