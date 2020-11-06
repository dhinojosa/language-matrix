national_league = {'reds':'Cincinnati Reds',
                   'dodgers': 'Los Angeles Dodgers',
                   'braves' : 'Atlanta Braves',
                   'astros': 'Houston Astros'}


assert (national_league.get('reds') == 'Cincinnati Reds')

# Getting a value for a key that isn't there will just return a None

assert (national_league.get('diamondbacks') == None)

# `items` return key value pairs as a dict_items object

dict_items = national_league.items()

# dict_items can be wrapped in a list to accessed it by index
# or iterated

dict_list = list(dict_items)
item = dict_list[0][0]
assert(item == 'reds')

value_with_default = national_league.get('diamond backs', 'not found')
assert (value_with_default == 'not found')

# Adding an element requires a mapping object
# A Mapping Object is {}, {k1 : v1, k2 : v2}

national_league.update({'padres': 'San Diego Padres'})
print(list(national_league.values())[1])

# Determine if a key is contained
print(national_league.__contains__('padres'))
