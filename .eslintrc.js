module.exports = {
    env: {
        browser: true,
        es2020: true
    },
    parser: 'babel-eslint',
    extends: ['prettier', 'plugin:react/recommended', 'airbnb'],
    parserOptions: {
        ecmaFeatures: {
            jsx: true
        },
        ecmaVersion: 11,
        sourceType: 'module'
    },
    plugins: ['prettier', 'react'],
    rules: {
        'operator-linebreak': 'after',
        'arrow-parens': ['error', 'as-needed', { requireForBlockBody: true }],
        'no-undef': 0,
        'comma-dangle': ['error', 'never'],
        'import/no-named-as-default': 0,
        'react/jsx-filename-extension': 0,
        'function-paren-newline': 0,
        'implicit-arrow-linebreak': 0,
        'react/sort-comp': 0,
        'object-curly-newline': 0,
        'max-classes-per-file': 0,
        'no-use-before-define': 0,
        'class-methods-use-this': 0,
        'consistent-return': 0,
        'react/prop-types': 0,
        'react/destructuring-assignment': 1,
        'import/prefer-default-export': 0
    }
};
