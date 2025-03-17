INSERT INTO paymentproviders(id, country, industry,payment) VALUES (1, 'USA', 'Financial Services', 'Credit Card');
INSERT INTO paymentproviders(id, country, industry,payment) VALUES (2, 'UK', 'Bank', 'Debit Card');
INSERT INTO paymentproviders(id, country, industry,payment) VALUES (3, 'Bangladesh', 'Financial Services', 'Debit Card');
INSERT INTO paymentproviders(id, country, industry,payment) VALUES (4, 'Turkey', 'Bank', 'Credit Card');
ALTER SEQUENCE paymentproviders_seq RESTART WITH 5;