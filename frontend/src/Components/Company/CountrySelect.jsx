import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';

export default function CountrySelect() {
    return (
        <Autocomplete
            id="country-select-demo"
            sx={{ width: 300 }}
            options={countries}
            autoHighlight
            getOptionLabel={(option) => option.label}
            renderOption={(props, option) => {
                const { key, ...optionProps } = props;
                return (
                    <Box
                        key={key}
                        component="li"
                        sx={{ '& > img': { mr: 2, flexShrink: 0 } }}
                        {...optionProps}
                    >
                        <img
                            loading="lazy"
                            width="20"
                            srcSet={`https://flagcdn.com/w40/${option.code.toLowerCase()}.png 2x`}
                            src={`https://flagcdn.com/w20/${option.code.toLowerCase()}.png`}
                            alt=""
                        />
                        {option.label} ({option.code}) +{option.phone}
                    </Box>
                );
            }}
            renderInput={(params) => (
                <TextField
                    {...params}
                    label="Location"
                    inputProps={{
                        ...params.inputProps,
                        autoComplete: 'new-password', // disable autocomplete and autofill
                    }}
                />
            )}
        />
    );
}
const countries = [
  { code: 'AD', label: 'Andorra', phone: '376' },
  { code: 'AL', label: 'Albania', phone: '355' },
  { code: 'AM', label: 'Armenia', phone: '374' },
  { code: 'AT', label: 'Austria', phone: '43' },
  { code: 'AZ', label: 'Azerbaijan', phone: '994' },
  { code: 'BE', label: 'Belgium', phone: '32' },
  { code: 'BG', label: 'Bulgaria', phone: '359' },
  { code: 'BY', label: 'Belarus', phone: '375' },
  { code: 'CH', label: 'Switzerland', phone: '41' },
  { code: 'CY', label: 'Cyprus', phone: '357' },
  { code: 'CZ', label: 'Czech Republic', phone: '420' },
  { code: 'DE', label: 'Germany', phone: '49' },
  { code: 'DK', label: 'Denmark', phone: '45' },
  { code: 'EE', label: 'Estonia', phone: '372' },
  { code: 'ES', label: 'Spain', phone: '34' },
  { code: 'FI', label: 'Finland', phone: '358' },
  { code: 'FR', label: 'France', phone: '33' },
  { code: 'GE', label: 'Georgia', phone: '995' },
  { code: 'GR', label: 'Greece', phone: '30' },
  { code: 'HR', label: 'Croatia', phone: '385' },
  { code: 'HU', label: 'Hungary', phone: '36' },
  { code: 'IE', label: 'Ireland', phone: '353' },
  { code: 'IS', label: 'Iceland', phone: '354' },
  { code: 'IT', label: 'Italy', phone: '39' },
  { code: 'KZ', label: 'Kazakhstan', phone: '7' },
  { code: 'LI', label: 'Liechtenstein', phone: '423' },
  { code: 'LT', label: 'Lithuania', phone: '370' },
  { code: 'LU', label: 'Luxembourg', phone: '352' },
  { code: 'LV', label: 'Latvia', phone: '371' },
  { code: 'MC', label: 'Monaco', phone: '377' },
  { code: 'MD', label: 'Moldova', phone: '373' },
  { code: 'ME', label: 'Montenegro', phone: '382' },
  { code: 'MK', label: 'Macedonia', phone: '389' },
  { code: 'MT', label: 'Malta', phone: '356' },
  { code: 'NL', label: 'Netherlands', phone: '31' },
  { code: 'NO', label: 'Norway', phone: '47' },
  { code: 'PL', label: 'Poland', phone: '48' },
  { code: 'PT', label: 'Portugal', phone: '351' },
  { code: 'RO', label: 'Romania', phone: '40' },
  { code: 'RS', label: 'Serbia', phone: '381' },
  { code: 'RU', label: 'Russia', phone: '7' },
  { code: 'SE', label: 'Sweden', phone: '46' },
  { code: 'SI', label: 'Slovenia', phone: '386' },
  { code: 'SK', label: 'Slovakia', phone: '421' },
  { code: 'SM', label: 'San Marino', phone: '378' },
  { code: 'TR', label: 'Turkey', phone: '90' },
  { code: 'UA', label: 'Ukraine', phone: '380' },
  { code: 'UK', label: 'United Kingdom', phone: '44' },
  { code: 'VA', label: 'Vatican City', phone: '379' },
  { code: 'XK', label: 'Kosovo', phone: '383' },
  { code: 'US', label: 'United States', phone: '1' }
];